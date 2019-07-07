package com.app.mvpdemo.mvp.bean;

public class LoginDataBean {
    /**
    *msg	"操作成功"
     * code	200
     * data
     * id	"1de7ae41-758f-477f-af53-ea6bc8adb394"
     * username	"zhaoliying3"
     * name	"赵丽颖3"
     * password	"4fd9ea40f4e97c8f898985b253bdefcd"
     * number	"2019003"
     * englishName	"English3"
     * items	"项目点1"
     * itemId	"aefe8071-f923-4c3f-9bbb-766d5a00b93d"
     * phoneNumber	""
     * sex	"女"
     * statusToken	"1003a3b4-dca0-408e-abb8-21ca0d1ab559"
     * updateTime	"2019-06-18 17:10:34"
     * createTime	"2019-06-18 17:10:34"
    * */

    public String msg;
    public int code;
    public TsysUser data;



    public TsysUser getData() {
        return data;
    }

    public void setData(TsysUser data) {
        this.data = data;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }



    @Override
    public String toString() {
        return "ResultBean{" +
                "msg='" + msg + '\'' +
                ", code=" + code +'\''+
                "data"+data + '\'' +
                '}';
    }
    public static class TsysUser{
        private String id ;
        private String username;
        private String name;
        private String password;
        private String number ;
        private String englishName;
        private String items;
        private String itemId;
        private String phoneNumber;
        private String sex ;
        private String statusToken;
        private String updateTime;
        private String createTime;


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getItemId() {
            return itemId;
        }

        public void setItemId(String itemId) {
            this.itemId = itemId;
        }

        public String getStatusToken() {
            return statusToken;
        }

        public void setStatusToken(String statusToken) {
            this.statusToken = statusToken;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getEnglishName() {
            return englishName;
        }

        public void setEnglishName(String englishName) {
            this.englishName = englishName;
        }

        public String getItems() {
            return items;
        }

        public void setItems(String items) {
            this.items = items;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        @Override
        public String toString() {
            return  "DataBean{" +
                    "id='" + id + '\'' +
                    ", username='" + username + '\'' +
                    ", name='" + name + '\'' +
                    ", password='" + password + '\'' +
                    ", number='" + number + '\'' +
                    ", englishName='" + englishName + '\'' +
                    ", items='" + items + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    ", sex='" + sex + '\'' +
                    ", updateTime='" + updateTime + '\'' +
                    ", createTime='" + createTime + '\'' +
                    '}';
        }
    }


}
