package com.example.android.videostreaming;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;


public class MainActivity extends ActionBarActivity implements SurfaceHolder.Callback{

    MediaPlayer mediaPlayer;
    SurfaceView surfaceView;
    SurfaceHolder surfaceHolder;
    boolean pausing = false;;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonPlayVideo = (Button)findViewById(R.id.playvideoplayer);

        getWindow().setFormat(PixelFormat.UNKNOWN);

        //Displays a video file.
        VideoView mVideoView = (VideoView)findViewById(R.id.videoview);


        String uriPath = "android.resource://com.example.android.videostreaming/"+R.raw.one;
        Uri uri = Uri.parse(uriPath);
        mVideoView.setVideoURI(uri);
        mVideoView.requestFocus();
        mVideoView.start();


        buttonPlayVideo.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        VideoViewActivity.class);
                startActivity(myIntent);

                /*// VideoView refference see main.xml
                VideoView mVideoView = (VideoView)findViewById(R.id.videoview);

                String uriPath = "android.resource://com.example.android.videostreaming/"+R.raw.one;

                Uri uri = Uri.parse(uriPath);
                mVideoView.setVideoURI(uri);
                mVideoView.requestFocus();
                mVideoView.start();
                mVideoView.seekTo(20000);*/


            }});

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

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
