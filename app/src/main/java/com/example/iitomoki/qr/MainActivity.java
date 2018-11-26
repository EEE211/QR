package com.example.iitomoki.qr;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.AndroidRuntimeException;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //QRコード化する文字列
        String data = "https://www.google.com";
        //QRコード画像の大きさを指定(pixel)
        int size = 500;

        try {
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            //QRコードをBitmapで作成
            Bitmap bitmap = barcodeEncoder.encodeBitmap(data,BarcodeFormat.QR_CODE, size, size);

            //作成したQRコードを画面上に配置
            ImageView imageViewQrCode = (ImageView) findViewById(R.id.imageView);
            imageViewQrCode.setImageBitmap(bitmap);

        } catch (WriterException e) {
            throw new AndroidRuntimeException("Barcode Error.", e);
        }


    }
}
