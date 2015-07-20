package org.pestrada.tallerandroid_hilos_webview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnHilo = (Button) findViewById(R.id.btnHilo);
        btnHilo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                probarHilo();
            }
        });

        WebView myWebView = (WebView) findViewById(R.id.webView);
        myWebView.loadUrl("http://www.donchambitas.com");
    }

    private void probarHilo() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final int total = 5 + 2;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TextView tvMensaje = (TextView) findViewById(R.id.tvMensaje);
                        tvMensaje.setText("La suma es: " + total);
                    }
                });
            }
        };
        new Thread(runnable).start();
    }

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
