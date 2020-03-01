package com.example.it2019asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageActivity extends AppCompatActivity {

    public static final String URL_KEY = "URL_KEY";

    private ProgressBar progress;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        progress = findViewById(R.id.progress);
        image = findViewById(R.id.image);

        String url = getIntent().getStringExtra(URL_KEY);

        Picasso.get()
                .load(url)
                .placeholder(R.drawable.loading)
                .error(R.drawable.error)
                .into(image);

      /*ImageLoadTesk task = new ImageLoadTesk();
        task.execute(url);*/
    }

/*
    private void setProgress(boolean flag) {
        if (flag) {
            progress.setVisibility(View.VISIBLE);
            image.setVisibility(View.GONE);
        } else {
            progress.setVisibility(View.GONE);
            image.setVisibility(View.VISIBLE);
        }
    }

    private void showError(String error) {
        Toast.makeText(getApplicationContext(), error, Toast.LENGTH_LONG).show();
    }

    class ImageLoadTesk extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected void onPreExecute() {
            setProgress(true);
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap result = null;
            try {
                URL url = new URL(strings[0]);
                result = BitmapFactory.decodeStream(url.openStream());

                *//*File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(),
                        "1.jpg");

                if (!file.isFile())
                    file.createNewFile();

                FileOutputStream fos = new FileOutputStream(file);
                result.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                fos.close();*//*

            } catch (Exception e) {
                e.printStackTrace();
                result = null;
            }
            return result;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            setProgress(false);
            if (bitmap == null) {
                showError("Load error!!!");
            } else {
                image.setImageBitmap(bitmap);
            }
        }
    }*/


}
