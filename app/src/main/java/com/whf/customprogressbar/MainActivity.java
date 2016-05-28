package com.whf.customprogressbar;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private CustomHorizontalProgressBar progressBar;
    private static final int MSG_PROGRESS_UPDATE = 0x1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (CustomHorizontalProgressBar) findViewById(R.id.custom_horizontal_progressbar);
        myHandler.sendEmptyMessage(MSG_PROGRESS_UPDATE);
    }

    private Handler myHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MSG_PROGRESS_UPDATE:
                    int mProgress = progressBar.getProgress();
                    if (mProgress >= 100) {
                        myHandler.removeMessages(MSG_PROGRESS_UPDATE);
                        break;
                    }
                    progressBar.setProgress(++mProgress);
                    myHandler.sendEmptyMessageDelayed(MSG_PROGRESS_UPDATE, 200);
                    break;

            }
        }
    };

}
