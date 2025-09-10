package system.flight.services;

import system.flight.dto.ApiResponseDTO;
import system.flight.dto.FeedbackDTO;
import system.flight.entities.Feedback;

public interface FeedbackService {

    public ApiResponseDTO<FeedbackDTO> submitFeedback(FeedbackDTO dto);

    public ApiResponseDTO<Feedback> getFeedback(int feedbackId);

    public ApiResponseDTO<Void> deleteFeedback(int feedbackId);
}
