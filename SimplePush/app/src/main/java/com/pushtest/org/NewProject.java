package com.pushtest.org;

public class NewProject {
    String userID;
    String title;/*프로젝트 명*/
    String content;/*프로젝트 이름*/
    int teamNum;/*팀원 모집 수*/
    boolean state;    /*모집 현황*/

    NewProject(){
        title="";
        content="-";
        teamNum=0;
        state=false;
    }

    public void setUserID(String userID) {this.userID=userID; }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setState(int nowNum) {
        if(this.teamNum==nowNum) state=true;
    }
    public void setTeamNum(int teamNum) {
        this.teamNum = teamNum;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
    public int getTeamNum() { return teamNum; }
    public String getTitle() { return title; }
    public String getUserID(){return userID;}
}

