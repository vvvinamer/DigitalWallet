package lld.booking.strategy;

import lld.booking.Bookable;
import lld.booking.request.SearchRequest;

import java.util.List;

public interface BookableSearchStrategy<B extends Bookable, R extends SearchRequest> {

     List<B> filterBookables(List<B> bookables, R searchRequest);

}
