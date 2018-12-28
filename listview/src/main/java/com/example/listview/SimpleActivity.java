package com.example.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleActivity extends AppCompatActivity {
    private List<Map<String,Object>>  listInfos ;
    private String[] spNames = {"京东","QQ","QQ斗地主","新浪微博","网易云","天猫","UC浏览器","微信","淘宝","华为","小米"} ;
    private int[] spto = {R.drawable.dig,R.drawable.dig1,R.drawable.dig2,R.drawable.dig3,R.drawable.ewm,R.drawable.gu2,R.drawable.gu3,R.drawable.gu4,R.drawable.gu5,R.drawable.gy1,R.drawable.phone};
    private int[] controlId = {R.id.sptv_item,R.id.spimgs} ;
    private String[] mapKey = {"names","icons"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        listInfos = new ArrayList<Map<String,Object>>() ;
        for (int i = 0; i < spNames.length; i++) {
            Map<String,Object> map = new HashMap<String, Object>() ;
            map.put("names",spNames[i]) ;
            map.put("icons",spto[i]) ;
            listInfos.add(map) ;
        }

        //new SimpleAdapter(Context,list<map<String,obj>>,Itemlayout.id,StringMapKey[],ItemControl.id)
        //在这个activity，遍历还是一一对应mapkey？ 到list<map>里循环找map并取值放到Itemlayout的control中
        SimpleAdapter sa = new SimpleAdapter(this,listInfos,R.layout.spitem_layout,mapKey,controlId) ;

        ListView lv = (ListView)findViewById(R.id.splistview) ;

        lv.setAdapter(sa);
    }
}
