package com.tirth.paymentservice.service;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import com.tirth.paymentservice.domain.PaymentMethod;
import com.tirth.paymentservice.modal.PaymentOrder;
import com.tirth.paymentservice.payload.dto.BookingDTO;
import com.tirth.paymentservice.payload.dto.UserDTO;
import com.tirth.paymentservice.payload.response.PaymentLinkResponse;

public interface PaymentService {

    PaymentLinkResponse createOrder(UserDTO userDTO,
                                    BookingDTO bookingDTO,
                                    PaymentMethod paymentMethod) throws RazorpayException, StripeException;

    PaymentOrder getPaymentOrderById(Long id) throws Exception;

    PaymentOrder getPaymentOrderByPaymentId(String paymentId);

    PaymentLink createRazorpayPaymentLink(UserDTO userDTO,
                                          Long amount,
                                          Long orderId) throws RazorpayException;

    String createStripePaymentLink(UserDTO userDTO,
                                   Long amount,
                                   Long orderId) throws StripeException;

    Boolean proceedPayment(PaymentOrder paymentOrder, String paymentId, String paymentLinkId) throws RazorpayException;
}
