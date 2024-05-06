package tourstApp.util;

import tourstApp.model.Rating;

public class RatingDrl {
    
    private Integer id;
    private Integer arrangementId;
    private double ratingValue;
    private Long userId;

    public RatingDrl() {
    }

    public RatingDrl(Integer id, Integer arrangementId, double ratingValue, Long userId) {
        this.id = id;
        this.arrangementId = arrangementId;
        this.ratingValue = ratingValue;
        this.userId = userId;
    }

    public RatingDrl(Rating rating){
        this.id = rating.getId();
        this.arrangementId = rating.getArrangement().getId();
        this.ratingValue = rating.getRatingValue();
        this.userId = rating.getUser().getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArrangementId() {
        return arrangementId;
    }

    public void setArrangementId(Integer arrangementId) {
        this.arrangementId = arrangementId;
    }

    public double getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(double ratingValue) {
        this.ratingValue = ratingValue;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
