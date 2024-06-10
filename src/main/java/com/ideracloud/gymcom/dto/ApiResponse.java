package com.ideracloud.gymcom.dto;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Date;

public class ApiResponse<T> implements Serializable {
    private Date timestamp;
    private int status;
    private String message;
    private T body;

    public static ApiResponse ok(HttpStatus status) {
        return ok(status, (Object)null, (String)null);
    }

    public static ApiResponse ok(Object obj) {
        return ok(HttpStatus.OK, obj, "success");
    }

    public static ApiResponse ok(HttpStatus status, Object obj) {
        return ok(status, obj, "success");
    }

    public static ApiResponse ok(Object obj, String message) {
        return ok(HttpStatus.OK, obj, message);
    }

    public static ApiResponse ok(HttpStatus status, String message) {
        return ok(status, (Object)null, message);
    }

    public static ApiResponse ok(HttpStatus status, Object obj, String message) {
        return builder().status(status.value()).message(message).timestamp(new Date()).body(obj).build();
    }

    public static ApiResponse ko(HttpStatus status, Object obj, String message) {
        return builder().status(status.value()).message(message).timestamp(new Date()).body(obj).build();
    }

    public static <T> ApiResponseBuilder<T> builder() {
        return new ApiResponseBuilder();
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public int getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public T getBody() {
        return this.body;
    }

    public void setTimestamp(final Date timestamp) {
        this.timestamp = timestamp;
    }

    public void setStatus(final int status) {
        this.status = status;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public void setBody(final T body) {
        this.body = body;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ApiResponse)) {
            return false;
        } else {
            ApiResponse<?> other = (ApiResponse)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getStatus() != other.getStatus()) {
                return false;
            } else {
                label49: {
                    Object this$timestamp = this.getTimestamp();
                    Object other$timestamp = other.getTimestamp();
                    if (this$timestamp == null) {
                        if (other$timestamp == null) {
                            break label49;
                        }
                    } else if (this$timestamp.equals(other$timestamp)) {
                        break label49;
                    }

                    return false;
                }

                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }

                Object this$body = this.getBody();
                Object other$body = other.getBody();
                if (this$body == null) {
                    if (other$body != null) {
                        return false;
                    }
                } else if (!this$body.equals(other$body)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ApiResponse;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        result = result * 59 + this.getStatus();
        Object $timestamp = this.getTimestamp();
        result = result * 59 + ($timestamp == null ? 43 : $timestamp.hashCode());
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        Object $body = this.getBody();
        result = result * 59 + ($body == null ? 43 : $body.hashCode());
        return result;
    }

    public String toString() {
        return "ApiResponse(timestamp=" + this.getTimestamp() + ", status=" + this.getStatus() + ", message=" + this.getMessage() + ", body=" + this.getBody() + ")";
    }

    public ApiResponse() {
    }

    public ApiResponse(final Date timestamp, final int status, final String message, final T body) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.body = body;
    }

    public static class ApiResponseBuilder<T> {
        private Date timestamp;
        private int status;
        private String message;
        private T body;

        ApiResponseBuilder() {
        }

        public ApiResponseBuilder<T> timestamp(final Date timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ApiResponseBuilder<T> status(final int status) {
            this.status = status;
            return this;
        }

        public ApiResponseBuilder<T> message(final String message) {
            this.message = message;
            return this;
        }

        public ApiResponseBuilder<T> body(final T body) {
            this.body = body;
            return this;
        }

        public ApiResponse<T> build() {
            return new ApiResponse(this.timestamp, this.status, this.message, this.body);
        }

        public String toString() {
            return "ApiResponse.ApiResponseBuilder(timestamp=" + this.timestamp + ", status=" + this.status + ", message=" + this.message + ", body=" + this.body + ")";
        }
    }
}