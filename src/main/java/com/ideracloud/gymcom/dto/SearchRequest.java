package com.ideracloud.gymcom.dto;

import org.springframework.data.domain.Sort;

public class SearchRequest<D>{

        private D criteria;
        private int page;
        private int size;
        private String sortField;
        private Sort.Direction direction;

        public SearchRequest() {
        }

        public D getCriteria() {
            return this.criteria;
        }

        public int getPage() {
            return this.page;
        }

        public int getSize() {
            return this.size;
        }

        public String getSortField() {
            return this.sortField;
        }

        public Sort.Direction getDirection() {
            return this.direction;
        }

        public void setCriteria(final D criteria) {
            this.criteria = criteria;
        }

        public void setPage(final int page) {
            this.page = page;
        }

        public void setSize(final int size) {
            this.size = size;
        }

        public void setSortField(final String sortField) {
            this.sortField = sortField;
        }

        public void setDirection(final Sort.Direction direction) {
            this.direction = direction;
        }

        public boolean equals(final Object o) {
            if (o == this) {
                return true;
            } else if (!(o instanceof SearchRequest)) {
                return false;
            } else {
                SearchRequest<?> other = (SearchRequest)o;
                if (!other.canEqual(this)) {
                    return false;
                } else if (this.getPage() != other.getPage()) {
                    return false;
                } else if (this.getSize() != other.getSize()) {
                    return false;
                } else {
                    label52: {
                        Object this$criteria = this.getCriteria();
                        Object other$criteria = other.getCriteria();
                        if (this$criteria == null) {
                            if (other$criteria == null) {
                                break label52;
                            }
                        } else if (this$criteria.equals(other$criteria)) {
                            break label52;
                        }

                        return false;
                    }

                    Object this$sortField = this.getSortField();
                    Object other$sortField = other.getSortField();
                    if (this$sortField == null) {
                        if (other$sortField != null) {
                            return false;
                        }
                    } else if (!this$sortField.equals(other$sortField)) {
                        return false;
                    }

                    Object this$direction = this.getDirection();
                    Object other$direction = other.getDirection();
                    if (this$direction == null) {
                        if (other$direction != null) {
                            return false;
                        }
                    } else if (!this$direction.equals(other$direction)) {
                        return false;
                    }

                    return true;
                }
            }
        }

        protected boolean canEqual(final Object other) {
            return other instanceof SearchRequest;
        }

        public int hashCode() {
            int result = 1;
            result = result * 59 + this.getPage();
            result = result * 59 + this.getSize();
            Object $criteria = this.getCriteria();
            result = result * 59 + ($criteria == null ? 43 : $criteria.hashCode());
            Object $sortField = this.getSortField();
            result = result * 59 + ($sortField == null ? 43 : $sortField.hashCode());
            Object $direction = this.getDirection();
            result = result * 59 + ($direction == null ? 43 : $direction.hashCode());
            return result;
        }

        public String toString() {
            return "SearchRequest(criteria=" + this.getCriteria() + ", page=" + this.getPage() + ", size=" + this.getSize() + ", sortField=" + this.getSortField() + ", direction=" + this.getDirection() + ")";
        }
}

