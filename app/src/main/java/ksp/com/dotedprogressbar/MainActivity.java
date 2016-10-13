package ksp.com.dotedprogressbar;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private DotsProgressBar progressBar;
    private  TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }


    private void initView() {

        progressBar = (DotsProgressBar) findViewById(R.id.dotsProgressBar);
        progressBar.setDotsCount(5);
        textView   = (TextView) findViewById(R.id.textView);
        textView.setVisibility(View.VISIBLE);
        DownloadTask task = new DownloadTask();
        task.execute();
    }

    class DownloadTask extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
            textView.setVisibility(View.VISIBLE);
            progressBar.start();
        }

        @Override
        protected Boolean doInBackground(Void... arg0) {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {

                e.printStackTrace();
                return false;
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if (result) {
                progressBar.stop();
                progressBar.setVisibility(View.INVISIBLE);
                textView.setVisibility(View.INVISIBLE);
            }
        }

    }
}
