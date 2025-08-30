package coding.booking.strategy;

import coding.booking.Bookable;
import coding.booking.request.SearchRequest;

import java.util.List;

public interface BookableSearchStrategy<B extends Bookable, R extends SearchRequest> {

     List<B> filterBookables(List<B> bookables, R searchRequest);

}
