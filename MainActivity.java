package com.example.cameratest;
import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity
{
	ImageView imgView;
	String path="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		
		setContentView(R.layout.activity);
		
		
		Button btnGallery=(Button)findViewById(R.id.btnGallery);
		Button btnCamera=(Button)findViewById(R.id.btnCamera);
		
		imgView=(ImageView)findViewById(R.id.imgView);
		
		
		
		
		btnCamera.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
		
				Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				
				
				 path="/storage/sdcard0/srikanth.jpg";
				
				File f=new File(path);
				
				i.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
				
				startActivityForResult(i, 0); 
					
			}
		});
		
		
		btnGallery.setOnClickListener(new OnClickListener()
		{	
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				
				Intent i=new Intent(Intent.ACTION_PICK); 
				i.setType("image/*");
				startActivityForResult(i, 1); 
				
				
			}
		});
		
		
		
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		
		if(requestCode==0)
		{
			File f=new File(path);
			
			imgView.setImageURI(Uri.fromFile(f)); 
			
			
		}
		
		else if(requestCode==1)
		{
		
		imgView.setImageURI(data.getData()); 
		
		}	
	}	
}