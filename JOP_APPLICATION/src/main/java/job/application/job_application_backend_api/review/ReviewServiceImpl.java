package job.application.job_application_backend_api.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    private ReviewRepository reviewRepository;
    @Override
    public List<Review> getAllReview() {

        return this.reviewRepository.findAll();
    }

    @Override
    public Review createReviews(Review review) {
        return this.reviewRepository.save(review);
    }

    @Override
    public void deleteReviewById(Integer id) {
        Review review=this.reviewRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));
        this.reviewRepository.delete(review);
    }

    @Override
    public Review updateReview(Review review, Integer id) {
        Review updatedReview=this.reviewRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));
        updatedReview.setDescription(review.getDescription());
        updatedReview.setTitle(review.getTitle());
        updatedReview.setRating(review.getRating());
        return this.reviewRepository.save(updatedReview);
    }

    @Override
    public Review getAllReviewById(Integer id) {

        return this.reviewRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }
}
