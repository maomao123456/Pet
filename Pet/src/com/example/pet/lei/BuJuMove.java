package com.example.pet.lei;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Display;
import android.widget.RelativeLayout;

public class BuJuMove extends RelativeLayout {
	private int width;
	private int height;
	private int screenHeight;
	private boolean sizeChanged = false;
	private OnSizeChangedListener onSizeChangedListener;
	public BuJuMove(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		Display localDisplay = ((Activity) context).getWindowManager()
				.getDefaultDisplay();
		screenHeight = localDisplay.getHeight();
	}
	public BuJuMove(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	public BuJuMove(Context context) {
		super(context);
	}
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		this.width = widthMeasureSpec;
		this.height = heightMeasureSpec;
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		// TODO Auto-generated method stub
		// 监听不为空、宽度不变、当前高度与历史高度不为0
		if (this.onSizeChangedListener != null && w == oldw && h != 0
				&& oldh != 0) {

			if (h >= oldh || (Math.abs(h - oldh) <= 1 * this.screenHeight / 4)) {
				sizeChanged = false;
			} else if (h <= oldh
					|| (Math.abs(h - oldh) <= 1 * this.screenHeight / 4)) {
				sizeChanged = true;
			}
			this.onSizeChangedListener.onSizeChange(sizeChanged);
			measure(this.width - w + getWidth(), this.height - h + getHeight());
		}
	}
	/**
	 * [email protected]: setOnSizeChangedListener [email protected]:
	 * 为当前布局设置onSizeChanged监听器 [email protected] [email protected]
	 */
	public void setOnSizeChangedListener(
			OnSizeChangedListener sizeChangedListener) {
		this.onSizeChangedListener = sizeChangedListener;
	}
	public abstract interface OnSizeChangedListener {
		public abstract void onSizeChange(boolean flag);
	}
}
