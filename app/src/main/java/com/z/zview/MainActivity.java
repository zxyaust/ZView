package com.z.zview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.z.zviewlib.ZImageView;
import com.z.zviewlib.ZLinearLayout;
import com.z.zviewlib.ZTextView;

public class MainActivity extends AppCompatActivity {


    private ZTextView mTv1ZTextView;
    private ZLinearLayout mLlZLinearLayout;
    private ZImageView mZivZImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTv1ZTextView = (ZTextView) findViewById(R.id.tv1);
        mLlZLinearLayout = (ZLinearLayout) findViewById(R.id.ll);
        mZivZImageView = (ZImageView) findViewById(R.id.ziv);


    }


    public void normal(View view) {
        mTv1ZTextView.setSelected(false);
        mTv1ZTextView.setEnabled(true);
        mLlZLinearLayout.setSelected(false);
        mLlZLinearLayout.setEnabled(true);
        mZivZImageView.setSelected(false);
        mZivZImageView.setEnabled(true);
    }

    public void unable(View view) {
        mTv1ZTextView.setEnabled(false);
        mLlZLinearLayout.setEnabled(false);
        mZivZImageView.setEnabled(false);
    }

    public void select(View view) {
        mTv1ZTextView.setSelected(true);
        mLlZLinearLayout.setSelected(true);
        mZivZImageView.setSelected(true);
    }

}
