package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.Toast;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListAdapter listAdapter;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.list);
        mListView.setAdapter(new MyAdapter());
        mListView.setOnItemClickListener(onClickListView);
    }
    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            Holder holder;
            Toast toast;

            if(v == null){
                v= getLayoutInflater().inflate(R.layout.adapter, null);
                holder = new Holder();
                holder.image = (ImageView) v.findViewById(R.id.image);
                holder.text = (TextView) v.findViewById(R.id.text);

                v.setTag(holder);
            } else{
                holder = (Holder) v.getTag();
            }
            switch(position) {
                case 0:
                    holder.image.setImageResource(R.drawable.shin);
                    holder.text.setText("小新");
                    break;
                case 1:
                    holder.image.setImageResource(R.drawable.kazama);
                    holder.text.setText("風間");
                    break;
                case 2:
                    holder.image.setImageResource(R.drawable.masao);
                    holder.text.setText("正男");
                    break;
                case 3:
                    holder.image.setImageResource(R.drawable.bo);
                    holder.text.setText("阿呆");
                    break;
                case 4:
                    holder.image.setImageResource(R.drawable.nene);
                    holder.text.setText("妮妮");
                    break;
            }
            return v;
        }
        class Holder{
            ImageView image;
            TextView text;
        }
    }
    /***
     * 點擊ListView事件Method
     */
    private AdapterView.OnItemClickListener onClickListView = new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            //Toast 快顯功能 第三個參數 Toast.LENGTH_SHORT 2秒  LENGTH_LONG 5秒
            switch(position) {
                case 0:
                    Toast.makeText(MainActivity.this,"野原 新之助", Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    Toast.makeText(MainActivity.this,"風間 徹", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(MainActivity.this,"佐藤 正男", Toast.LENGTH_SHORT).show();
                    break;
                case 3:
                    Toast.makeText(MainActivity.this,"阿呆", Toast.LENGTH_SHORT).show();
                    break;
                case 4:
                    Toast.makeText(MainActivity.this,"櫻田 妮妮", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
}