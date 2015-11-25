package com.example.insomnia.weather.source;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by insomnia on 2015/11/16.
 */
public class ProvincesData {
    JSONArray data;
    public ProvincesData(){
        try {
            data = new JSONArray("[\n" +
                    "    {\n" +
                    "        \"city\": [\n" +
                    "            {\n" +
                    "                \"cityname\": \"北京\"\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"proname\": \"北京\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"city\": [\n" +
                    "            {\n" +
                    "                \"cityname\": \"天津\"\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"proname\": \"天津\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"city\": [\n" +
                    "            {\n" +
                    "                \"cityname\": \"上海\"\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"proname\": \"上海\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"city\": [\n" +
                    "            {\n" +
                    "                \"cityname\": \"重庆\"\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"proname\": \"重庆\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"city\": [\n" +
                    "            {\n" +
                    "                \"cityname\": \"保定\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"唐山\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"廊坊\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"张家口\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"承德\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"沧州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"石家庄\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"秦皇岛\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"衡水\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"邢台\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"邯郸\"\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"proname\": \"河北省\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"city\": [\n" +
                    "            {\n" +
                    "                \"cityname\": \"临汾\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"吕梁\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"大同\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"太原\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"忻州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"晋中\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"晋城\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"朔州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"运城\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"长治\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"阳泉\"\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"proname\": \"山西省\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"city\": [\n" +
                    "            {\n" +
                    "                \"cityname\": \"丹东\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"大连\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"抚顺\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"朝阳\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"本溪\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"沈阳\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"盘锦\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"营口\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"葫芦岛\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"辽阳\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"铁岭\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"锦州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"阜新\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"鞍山\"\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"proname\": \"辽宁省\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"city\": [\n" +
                    "            {\n" +
                    "                \"cityname\": \"吉林\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"四平\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"延边朝鲜族自治州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"松原\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"白城\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"白山\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"辽源\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"通化\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"长春\"\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"proname\": \"吉林省\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"city\": [\n" +
                    "            {\n" +
                    "                \"cityname\": \"七台河\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"伊 春 \"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"佳木斯\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"双鸭山\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"哈尔滨\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"大 庆 \"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"大兴安岭地区\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"牡丹江\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"绥 化 \"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"鸡 西 \"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"鹤 岗 \"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"黑 河 \"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"齐齐哈尔\"\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"proname\": \"黑龙江省\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"city\": [\n" +
                    "            {\n" +
                    "                \"cityname\": \"南京\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"南通\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"宿迁\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"常州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"徐州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"扬州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"无锡\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"泰州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"淮安\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"盐城\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"苏州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"连云港\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"镇江\"\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"proname\": \"江苏省\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"city\": [\n" +
                    "            {\n" +
                    "                \"cityname\": \"丽水\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"台州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"嘉兴\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"宁波\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"杭州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"温州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"湖州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"绍兴\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"舟山\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"衢州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"金华\"\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"proname\": \"浙江省\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"city\": [\n" +
                    "            {\n" +
                    "                \"cityname\": \"亳州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"六安\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"合肥\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"安庆\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"宣城\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"宿州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"巢湖\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"池州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"淮北\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"淮南\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"滁州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"芜湖\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"蚌埠\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"铜陵\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"阜阳\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"马鞍山\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"黄山\"\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"proname\": \"安徽省\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"city\": [\n" +
                    "            {\n" +
                    "                \"cityname\": \"三明\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"南平\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"厦门\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"宁德\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"泉州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"漳州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"福州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"莆田\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"龙岩\"\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"proname\": \"福建省\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"city\": [\n" +
                    "            {\n" +
                    "                \"cityname\": \"上饶\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"九江\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"南昌\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"吉安\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"宜春\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"抚州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"新余\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"景德镇\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"萍乡\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"赣州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"鹰潭\"\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"proname\": \"江西省\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"city\": [\n" +
                    "            {\n" +
                    "                \"cityname\": \"东营\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"临沂\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"威海\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"德州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"日照\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"枣庄\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"泰安\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"济南\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"济宁\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"淄博\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"滨州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"潍坊\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"烟台\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"聊城\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"莱芜\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"菏泽\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"青岛\"\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"proname\": \"山东省\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"city\": [\n" +
                    "            {\n" +
                    "                \"cityname\": \"三门峡\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"信阳\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"南阳\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"周口\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"商丘\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"安阳\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"平顶山\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"开封\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"新乡\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"洛阳\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"济源\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"漯河\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"濮阳\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"焦作\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"许昌\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"郑州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"驻马店\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"鹤壁\"\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"proname\": \"河南省\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"city\": [\n" +
                    "            {\n" +
                    "                \"cityname\": \"仙桃\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"十堰\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"咸宁\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"天门\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"孝感\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"宜昌\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"恩施土家族苗族自治州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"武汉\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"潜江\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"神农架林区\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"荆州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"荆门\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"襄樊\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"鄂州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"随州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"黄冈\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"黄石\"\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"proname\": \"湖北省\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"city\": [\n" +
                    "            {\n" +
                    "                \"cityname\": \"娄底\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"岳阳\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"常德\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"张家界\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"怀化\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"株洲\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"永州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"湘潭\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"湘西土家族苗族自治州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"益阳\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"衡阳\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"邵阳\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"郴州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"长沙\"\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"proname\": \"湖南省\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"city\": [\n" +
                    "            {\n" +
                    "                \"cityname\": \"东莞\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"中山\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"云浮\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"佛山\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"广州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"惠州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"揭阳\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"梅州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"汕头\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"汕尾\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"江门\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"河源\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"深圳\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"清远\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"湛江\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"潮州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"珠海\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"肇庆\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"茂名\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"阳江\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"韶关\"\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"proname\": \"广东省\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"city\": [\n" +
                    "            {\n" +
                    "                \"cityname\": \"临夏回族自治州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"兰州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"嘉峪关\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"天水\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"定西\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"平凉\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"庆阳\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"张掖\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"武威\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"甘南藏族自治州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"白银\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"酒泉\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"金昌\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"陇南\"\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"proname\": \"甘肃省\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"city\": [\n" +
                    "            {\n" +
                    "                \"cityname\": \"乐山\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"内江\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"凉山彝族自治州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"南充\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"宜宾\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"巴中\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"广元\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"广安\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"德阳\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"成都\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"攀枝花\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"泸州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"甘孜藏族自治州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"眉山\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"绵阳\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"自贡\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"资阳\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"达州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"遂宁\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"阿坝藏族羌族自治州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"雅安\"\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"proname\": \"四川省\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"city\": [\n" +
                    "            {\n" +
                    "                \"cityname\": \"六盘水\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"安顺\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"毕节地区\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"贵阳\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"遵义\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"铜仁地区\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"黔东南苗族侗族自治州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"黔南布依族苗族自治州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"黔西南布依族苗族自治州\"\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"proname\": \"贵州省\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"city\": [\n" +
                    "            {\n" +
                    "                \"cityname\": \"万宁\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"三亚\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"东方\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"临高县\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"乐东黎族自治县\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"五指山\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"保亭黎族苗族自治县\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"儋州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"定安县\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"屯昌县\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"文昌\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"昌江黎族自治县\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"海口\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"澄迈县\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"琼中黎族苗族自治县\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"琼海\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"白沙黎族自治县\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"陵水黎族自治县\"\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"proname\": \"海南省\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"city\": [\n" +
                    "            {\n" +
                    "                \"cityname\": \"临沧\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"丽江\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"保山\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"大理白族自治州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"德宏傣族景颇族自治州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"怒江傈傈族自治州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"思茅\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"文山壮族苗族自治州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"昆明\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"昭通\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"曲靖\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"楚雄彝族自治州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"玉溪\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"红河哈尼族彝族自治州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"西双版纳傣族自治州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"迪庆藏族自治州\"\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"proname\": \"云南省\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"city\": [\n" +
                    "            {\n" +
                    "                \"cityname\": \"果洛藏族自治州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"海东地区\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"海北藏族自治州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"海南藏族自治州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"海西蒙古族藏族自治州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"玉树藏族自治州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"西宁\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"黄南藏族自治州\"\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"proname\": \"青海省\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"city\": [\n" +
                    "            {\n" +
                    "                \"cityname\": \"咸阳\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"商洛\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"安康\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"宝鸡\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"延安\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"榆林\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"汉中\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"渭南\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"西安\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"铜川\"\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"proname\": \"陕西省\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"city\": [\n" +
                    "            {\n" +
                    "                \"cityname\": \"北海\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"南宁\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"崇左\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"来宾\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"柳州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"桂林\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"梧州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"河池\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"玉林\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"百色\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"贵港\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"贺州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"钦州\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"防城港\"\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"proname\": \"广西壮族自治区\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"city\": [\n" +
                    "            {\n" +
                    "                \"cityname\": \"山南地区\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"拉萨\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"日喀则地区\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"昌都地区\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"林芝地区\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"那曲地区\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"阿里地区\"\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"proname\": \"西藏自治区\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"city\": [\n" +
                    "            {\n" +
                    "                \"cityname\": \"中卫\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"吴忠\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"固原\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"石嘴山\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"银川\"\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"proname\": \"宁夏回族自治区\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"city\": [\n" +
                    "            {\n" +
                    "                \"cityname\": \"乌苏\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"乌鲁木齐\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"五家渠\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"伊宁\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"克拉玛依\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"博乐\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"吐鲁番\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"和田\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"哈密\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"喀什\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"图木舒克\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"塔城\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"奎屯\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"库尔勒\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"昌吉\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"石河子　\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"米泉\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"阜康\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"阿克苏\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"阿勒泰\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"阿图什\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"阿拉尔\"\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"proname\": \"新疆维吾尔自治区\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"city\": [\n" +
                    "            {\n" +
                    "                \"cityname\": \"乌兰察布\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"乌海\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"兴安盟\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"包头\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"呼伦贝尔\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"呼和浩特\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"巴彦淖尔\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"赤峰\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"通辽\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"鄂尔多斯\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"锡林郭勒盟\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"cityname\": \"阿拉善盟\"\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"proname\": \"内蒙古自治区\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"city\": [\n" +
                    "            {\n" +
                    "                \"cityname\": \"澳门\"\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"proname\": \"澳门\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"city\": [\n" +
                    "            {\n" +
                    "                \"cityname\": \"香港\"\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"proname\": \"香港\"\n" +
                    "    }\n" +
                    "]");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public JSONArray getData(){
        return data;
    }
    public int getProNum(){
        return data.length();
    }
    public int getCitiesNum(int proID){
        try {
            return data.getJSONObject(proID).getJSONArray("city").length();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public String getCityName(int proID,int cityPostion){
        try {
            return (String)data.getJSONObject(proID).getJSONArray("city").getJSONObject(cityPostion).get("cityname");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    public String getProName(int proID){
        try {
            return (String)data.getJSONObject(proID).get("proname");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "";
    }
    public ArrayList<String> getAllCitiesName(){
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i< data.length();i++){
            try {
                JSONObject object = data.getJSONObject(i);
                JSONArray array = object.getJSONArray("city");
                for (int j = 0; j < array.length(); j++){
                    result.add((String)array.getJSONObject(j).get("cityname"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
