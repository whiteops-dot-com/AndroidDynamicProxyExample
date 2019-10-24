package com.example.decoder;

import android.app.Application;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatCallback;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MainActivity extends AppCompatActivity {

    /* renamed from: K */
    public static String m15780K(String str) {
        int length = str.length();
        char[] cArr = new char[length];
        int i = length - 1;
        while (i >= 0) {
            int i2 = i - 1;
            cArr[i] = (char) (str.charAt(i) ^ '@');
            if (i2 < 0) {
                break;
            }
            i = i2 - 1;
            cArr[i2] = (char) (str.charAt(i2) ^ 'l');
        }
        return new String(cArr);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        testClass = new TestClass();
        StringBuilder sb1 = new StringBuilder("");
        //StringBuilder sb = new StringBuilder();
        //sb.append(m15780K("x\u0015}\tv\u0012}Ux\u000biUX\u0018m\u0012o\u0012m\u0002M\u0013k\u001ex\u001f"));
        //try {
        //    sb.append(C12284a.m29354a("d3Vk"));
        //} catch (UnsupportedEncodingException e) {
        //    e.printStackTrace();
        //}

        Bundle

        sb1.append( testClass.app.getClass());
        Log.d("test", sb1.toString());
        String str = "FtPMUkMFNMme,FtBMseCYnZ,FtAQUMtiYnCYnZ,FtCYntXntRXsYlvXr".replaceAll("Q", "ppli").replaceAll("U", "c").replaceAll("F", "ge").replaceAll("M", "a").replaceAll("Z", "text").replaceAll("X", "e").replaceAll("Y", "o");
        Log.d("test", str);
        final boolean message1 = testClass.app.test();
        try {
            Field declaredField = testClass.getClass().getDeclaredField("app");
            declaredField.setAccessible(true);
            InvocationHandler ih = new InvocationHandler() {
                @Override
                public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                    return method.getName().equals("test") ? Boolean.valueOf(true) : method.invoke(o, objects);
                }
            };
            try {
                IApplication px = (IApplication) Proxy.newProxyInstance(IApplication.class.getClassLoader(), new Class[]{IApplication.class}, ih);
                declaredField.set(testClass, px);
            } catch (Exception i){
                Log.d("test", "bbbbbbbbbbbbbbb");
            }
        } catch (NoSuchFieldException e) {
            Log.d("test", "aaaaaaaaaaaaaa");
        }

        sb1.append( testClass.app.hashCode());
        Log.d("test", sb1.toString());
        testClass.app.equals(new Object());
        FloatingActionButton fab = findViewById(R.id.fab);
        final boolean message2 = testClass.app.test();
        StringBuilder sb = new StringBuilder("");
        sb.append(message1);
        sb.append(message2);
        //Log.d(sb.toString(), sb.toString());
        //Log.d("test", testClass.app.toString());
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    TestClass testClass;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
