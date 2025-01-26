package job.application.job_application_backend_api.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @GetMapping("/")
    public ResponseEntity<List<Review>>getAllReview(){
        return new ResponseEntity<>(this.reviewService.getAllReview(), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<Review> createReview(@RequestBody Review review){
        return new ResponseEntity<>(this.reviewService.createReviews(review),HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable Integer id){
        this.reviewService.deleteReviewById(id);

        return new ResponseEntity<>("deleted ",HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Integer id){
        return new ResponseEntity<>(this.reviewService.getAllReviewById(id),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@RequestBody Review review,@PathVariable Integer id){
        return new ResponseEntity<>(this.reviewService.updateReview(review,id),HttpStatus.CREATED);
    }
}
