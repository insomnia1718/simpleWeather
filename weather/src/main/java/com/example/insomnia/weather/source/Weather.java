package com.example.insomnia.weather.source;

import java.util.List;

/**
 * Created by insomnia on 2015/11/6.
 */
public class Weather {



    /**
     * error : 0
     * status : success
     * date : 2015-11-06
     * results : [{"currentCity":"北京","pm25":"31","index":[{"title":"穿衣","zs":"冷","tipt":"穿衣指数","des":"天气冷，建议着棉服、羽绒服、皮夹克加羊毛衫等冬季服装。年老体弱者宜着厚棉衣、冬大衣或厚羽绒服。"},{"title":"洗车","zs":"不宜","tipt":"洗车指数","des":"不宜洗车，未来24小时内有雪，如果在此期间洗车，雪水和路上的泥水可能会再次弄脏您的爱车。"},{"title":"旅游","zs":"较适宜","tipt":"旅游指数","des":"天气稍冷，风比较小，预报有降雪，但雪量不大，或许会为您的行程增加些许情调。若出游可选择雪上项目。"},{"title":"感冒","zs":"极易发","tipt":"感冒指数","des":"将有一次强降温过程，天气寒冷，极易发生感冒，请特别注意增加衣服保暖防寒。"},{"title":"运动","zs":"较不宜","tipt":"运动指数","des":"有降雪，推荐您在室内进行低强度运动；若坚持户外运动，请选择合适运动并注意保暖。"},{"title":"紫外线强度","zs":"最弱","tipt":"紫外线强度指数","des":"属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。"}],"weather_data":[{"date":"周五 11月06日 (实时：3℃)","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/xiaoxue.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/xiaoxue.png","weather":"小雪","wind":"微风","temperature":"3 ~ 2℃"},{"date":"周六","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/yin.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/xiaoyu.png","weather":"阴转小雨","wind":"微风","temperature":"7 ~ 5℃"},{"date":"周日","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/yin.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/qing.png","weather":"阴转晴","wind":"微风","temperature":"11 ~ 1℃"},{"date":"周一","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/qing.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/qing.png","weather":"晴","wind":"微风","temperature":"13 ~ 0℃"}]}]
     */

    private int error;
    private String status;
    private String date;
    /**
     * currentCity : 北京
     * pm25 : 31
     * index : [{"title":"穿衣","zs":"冷","tipt":"穿衣指数","des":"天气冷，建议着棉服、羽绒服、皮夹克加羊毛衫等冬季服装。年老体弱者宜着厚棉衣、冬大衣或厚羽绒服。"},{"title":"洗车","zs":"不宜","tipt":"洗车指数","des":"不宜洗车，未来24小时内有雪，如果在此期间洗车，雪水和路上的泥水可能会再次弄脏您的爱车。"},{"title":"旅游","zs":"较适宜","tipt":"旅游指数","des":"天气稍冷，风比较小，预报有降雪，但雪量不大，或许会为您的行程增加些许情调。若出游可选择雪上项目。"},{"title":"感冒","zs":"极易发","tipt":"感冒指数","des":"将有一次强降温过程，天气寒冷，极易发生感冒，请特别注意增加衣服保暖防寒。"},{"title":"运动","zs":"较不宜","tipt":"运动指数","des":"有降雪，推荐您在室内进行低强度运动；若坚持户外运动，请选择合适运动并注意保暖。"},{"title":"紫外线强度","zs":"最弱","tipt":"紫外线强度指数","des":"属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。"}]
     * weather_data : [{"date":"周五 11月06日 (实时：3℃)","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/xiaoxue.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/xiaoxue.png","weather":"小雪","wind":"微风","temperature":"3 ~ 2℃"},{"date":"周六","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/yin.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/xiaoyu.png","weather":"阴转小雨","wind":"微风","temperature":"7 ~ 5℃"},{"date":"周日","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/yin.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/qing.png","weather":"阴转晴","wind":"微风","temperature":"11 ~ 1℃"},{"date":"周一","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/qing.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/qing.png","weather":"晴","wind":"微风","temperature":"13 ~ 0℃"}]
     */

    private List<ResultsEntity> results;

    public void setError(int error) {
        this.error = error;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setResults(List<ResultsEntity> results) {
        this.results = results;
    }

    public int getError() {
        return error;
    }

    public String getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }

    public List<ResultsEntity> getResults() {
        return results;
    }

    public static class ResultsEntity {
        private String currentCity;
        private String pm25;
        /**
         * title : 穿衣
         * zs : 冷
         * tipt : 穿衣指数
         * des : 天气冷，建议着棉服、羽绒服、皮夹克加羊毛衫等冬季服装。年老体弱者宜着厚棉衣、冬大衣或厚羽绒服。
         */

        private List<IndexEntity> index;
        /**
         * date : 周五 11月06日 (实时：3℃)
         * dayPictureUrl : http://api.map.baidu.com/images/weather/day/xiaoxue.png
         * nightPictureUrl : http://api.map.baidu.com/images/weather/night/xiaoxue.png
         * weather : 小雪
         * wind : 微风
         * temperature : 3 ~ 2℃
         */

        private List<WeatherDataEntity> weather_data;

        public void setCurrentCity(String currentCity) {
            this.currentCity = currentCity;
        }

        public void setPm25(String pm25) {
            this.pm25 = pm25;
        }

        public void setIndex(List<IndexEntity> index) {
            this.index = index;
        }

        public void setWeather_data(List<WeatherDataEntity> weather_data) {
            this.weather_data = weather_data;
        }

        public String getCurrentCity() {
            return currentCity;
        }

        public String getPm25() {
            return pm25;
        }

        public List<IndexEntity> getIndex() {
            return index;
        }

        public List<WeatherDataEntity> getWeather_data() {
            return weather_data;
        }

        public static class IndexEntity {
            private String title;
            private String zs;
            private String tipt;
            private String des;

            public void setTitle(String title) {
                this.title = title;
            }

            public void setZs(String zs) {
                this.zs = zs;
            }

            public void setTipt(String tipt) {
                this.tipt = tipt;
            }

            public void setDes(String des) {
                this.des = des;
            }

            public String getTitle() {
                return title;
            }

            public String getZs() {
                return zs;
            }

            public String getTipt() {
                return tipt;
            }

            public String getDes() {
                return des;
            }
        }

        public static class WeatherDataEntity {
            private String date;
            private String dayPictureUrl;
            private String nightPictureUrl;
            private String weather;
            private String wind;
            private String temperature;

            public void setDate(String date) {
                this.date = date;
            }

            public void setDayPictureUrl(String dayPictureUrl) {
                this.dayPictureUrl = dayPictureUrl;
            }

            public void setNightPictureUrl(String nightPictureUrl) {
                this.nightPictureUrl = nightPictureUrl;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }

            public void setWind(String wind) {
                this.wind = wind;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            public String getDate() {
                return date;
            }

            public String getDayPictureUrl() {
                return dayPictureUrl;
            }

            public String getNightPictureUrl() {
                return nightPictureUrl;
            }

            public String getWeather() {
                return weather;
            }

            public String getWind() {
                return wind;
            }

            public String getTemperature() {
                return temperature;
            }
        }
    }
}
