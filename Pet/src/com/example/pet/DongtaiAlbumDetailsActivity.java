package com.example.pet;

import java.util.ArrayList;
import java.util.List;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.pet.baseadapter.AlbumDetailsListviewAdapter;
import com.example.pet.classes.SysApplication;
import com.example.pet.lei.AlbumDetailsListview;
import com.example.pet.lei.SquareGridview;

@SuppressLint("InflateParams")
public class DongtaiAlbumDetailsActivity extends Activity{
	LayoutInflater inflater;
	View headview;
	View itemview;
	ListView listview;
	GridView gridview;
	AlbumDetailsListviewAdapter adapter;
	List<AlbumDetailsListview> list;
	AlbumDetailsListview albumDetails;
	int[] id={R.id.time_album_details_dongtai,R.id.gridview_album_details_dongtai};
	RelativeLayout back;
	TextView shangchuan;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_album_details_dongtai);
		SysApplication.getInstance().addActivity(this);
		init();
		listview.addHeaderView(headview);
		getList();
		adapter=new AlbumDetailsListviewAdapter(this, list, 
				R.layout.listview_item_album_details_dongtai, id);
		listview.setAdapter(adapter);
	}
	/**
	 * 找id，设点击
	 */
	@SuppressLint("InflateParams")
	public void init(){
		inflater=this.getLayoutInflater();
		headview=(View)inflater.inflate(R.layout.album_details_head_dongtai, null);
		itemview=(View)inflater.inflate(R.layout.listview_item_album_details_dongtai, null);
		listview=(ListView)findViewById(R.id.listview_album_details_dongtai);
		gridview=(GridView)itemview.findViewById(R.id.gridview_album_details_dongtai);
		back=(RelativeLayout)findViewById(R.id.back_album_details_dongtai);
		shangchuan=(TextView)findViewById(R.id.shangchuan_album_details);
		back.setOnClickListener(clickListener);
		shangchuan.setOnClickListener(clickListener);
	}
	OnClickListener clickListener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.back_album_details_dongtai:
				startActivity(new Intent(DongtaiAlbumDetailsActivity.this,MainActivity.class));
				DongtaiAlbumDetailsActivity.this.finish();
				break;
			case R.id.shangchuan_album_details:
				Toast.makeText(DongtaiAlbumDetailsActivity.this, "上传", Toast.LENGTH_SHORT).show();
				break;
			}
		}
	};
	/**
	 * 给listview添加数据
	 */
	String[] times={"2016年1月23日","2015年4月5日"};
	int[] imgs={R.drawable.photo_album_pic1,R.drawable.photo_album_pic2,
			R.drawable.photo_album_pic3,R.drawable.photo_album_pic4,R.drawable.photo_album_pic5};
	public void getList(){
		list=new ArrayList<AlbumDetailsListview>();
		List<SquareGridview> list_gridview=new ArrayList<SquareGridview>();
		SquareGridview squareGridview=new SquareGridview();
		albumDetails=new AlbumDetailsListview();
		albumDetails.setTime(times[0]);
		albumDetails.setList(list_gridview);
		squareGridview.setImage(R.drawable.photo_album_pic1);
		list_gridview.add(squareGridview);
		squareGridview=new SquareGridview();
		squareGridview.setImage(imgs[1]);
		list_gridview.add(squareGridview);
		squareGridview=new SquareGridview();
		squareGridview.setImage(imgs[2]);
		list_gridview.add(squareGridview);
		list.add(albumDetails);
		
		list_gridview=new ArrayList<SquareGridview>();
		squareGridview=new SquareGridview();
		squareGridview.setImage(imgs[3]);
		list_gridview.add(squareGridview);
		squareGridview=new SquareGridview();
		squareGridview.setImage(imgs[4]);
		list_gridview.add(squareGridview);
		albumDetails=new AlbumDetailsListview();
		albumDetails.setList(list_gridview);
		albumDetails.setTime(times[1]);
		list.add(albumDetails);
	}
}
