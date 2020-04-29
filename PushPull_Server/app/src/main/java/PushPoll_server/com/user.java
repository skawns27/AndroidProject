package PushPoll_server.com;

public class user {
    String id;//user ID
    int cnt_send;
    int cnt_rev;
    int cnt_click;
    int game_click;
    int sport_click;
    int movie_click;
    double rev_avg;//수신 성공
    double click_act;//push 확인

    public void put_rev_cnt(int cnt_rev)
    {
        this.cnt_rev=cnt_rev;
    }
    public void put_click_cnt(int cnt_click)
    {
        this.cnt_rev=cnt_rev;
    }
    double get_rev_avg(int cnt_rev)
    {
        this.cnt_rev=cnt_rev;
    }
}
