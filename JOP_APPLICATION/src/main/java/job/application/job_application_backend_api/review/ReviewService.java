package job.application.job_application_backend_api.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReview();

    Review createReviews(Review review);

    void deleteReviewById(Integer id);

    Review updateReview(Review review, Integer id);

    Review getAllReviewById(Integer id);
}
