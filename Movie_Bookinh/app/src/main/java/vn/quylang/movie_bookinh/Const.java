package vn.quylang.movie_bookinh;

import vn.quylang.movie_bookinh.Models.Movie;
import vn.quylang.movie_bookinh.Models.Showtime;

public class Const {
    public static final int FRAGMENT_HOME=0;
    public static final int FRAGMENT_ORDER_HISTORY=1;
    public static final int FRAGMENT_DETAIL_MOVIE=2;
    public static final int FRAGMENT_BOOKING=3;
    public static final int FRAGMENT_ORDER_DETAILS=4;
    public static final int FRAGMENT_CHANGE_PASSWORD=5;
    public static int CURRENT_FRAGMENT=FRAGMENT_HOME;

    public static Movie currentMovie;
    public static Showtime currentShowTime;
}
