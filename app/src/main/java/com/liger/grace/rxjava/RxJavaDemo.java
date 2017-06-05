package com.liger.grace.rxjava;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.liger.grace.R;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by Liger on 2017/5/12 17:56.
 */

public class RxJavaDemo extends AppCompatActivity {

    private final String TAG = "RxJavaDemo";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
        initRxJava();
    }

    private void initRxJava() {
        //创建被观察者
        Observable observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                //执行一些操作
                //.............
                //执行完毕，触发回调，通知观察者
                e.onNext("我来发射数据");
            }
        });
        //创建观察者
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            //观察者接收通知，进行相关的操作
            @Override
            public void onNext(@NonNull String s) {
                Log.d(TAG, "onNext: " + s);

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        //订阅通知
        observable.subscribe(observer);

        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                e.onNext("ss");
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {
                Log.d(TAG, "onNext: " + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        Observable.just("hello")
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(@NonNull String s) throws Exception {
                        Log.d(TAG, "accept: " + s);
                    }
                });

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("Hello" + i);
        }
        Observable observable1 = Observable.fromIterable(list);

        Observable observable2 = Observable.defer(new Callable<ObservableSource<? extends String>>() {
            @Override
            public ObservableSource<? extends String> call() throws Exception {
                return Observable.just("Hello");
            }
        });

        Observable observable3 = Observable.interval(2, TimeUnit.SECONDS);

        //map
        Observable.just("hello") // 输入类型 String
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(@NonNull String s) throws Exception { // 参数类型 String
                        return s.length();// 返回类型 Integer
                    }
                }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(@NonNull Integer integer) throws Exception { // 参数类型 Integer
                Log.d(TAG, "accept: " + integer); // 输出类型 Integer
            }
        });
        Subscriber subscriber = new Subscriber() {
            @Override
            public void onSubscribe(Subscription s) {

            }

            @Override
            public void onNext(Object o) {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {
                ImageView view=null;
                Glide.with(RxJavaDemo.this).load("").into(view);

            }
        };

       /* Observable.just("Hello").subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String s) throws Exception {
                Log.d(TAG, "accept: " + s);
            }
        });*/
        
       /* Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                Log.d(TAG, "事件产生的线程: " + Thread.currentThread().getName());
                e.onNext(1);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(@NonNull Integer integer) throws Exception {
                        Log.d(TAG, "接收的线程: " + Thread.currentThread().getName());
                    }
                });*/
    }
}
