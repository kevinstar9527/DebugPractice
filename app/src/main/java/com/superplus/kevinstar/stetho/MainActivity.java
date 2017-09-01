package com.superplus.kevinstar.stetho;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;
import com.wuxiaolong.androidutils.library.SharedPreferencesUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferencesUtil.setString(this, "ceshi", "ceshi");
        Button button = (Button) findViewById(R.id.button);
        //测试Stetho是否可以修改SharePreference
        //测试结果是正确的
        button.setText("查看SharePreference");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sharePreference = SharedPreferencesUtil.getString(MainActivity.this,"ceshi","搜索是失败");
                new QMUIDialog.MessageDialogBuilder(MainActivity.this)
                        .setTitle("标题")
                        .setMessage(sharePreference)
                        .addAction("取消", new QMUIDialogAction.ActionListener() {
                            @Override
                            public void onClick(QMUIDialog dialog, int index) {
                                dialog.dismiss();
                            }
                        })
                        .addAction("测试Leak", new QMUIDialogAction.ActionListener() {
                            @Override
                            public void onClick(QMUIDialog dialog, int index) {
                                dialog.dismiss();
                                Toast.makeText(MainActivity.this, "打开activity", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent();
                                intent.setClass(MainActivity.this,TestLeakActivity.class);
                                startActivity(intent);
                            }
                        }).show();
            }
        });
    }
}
