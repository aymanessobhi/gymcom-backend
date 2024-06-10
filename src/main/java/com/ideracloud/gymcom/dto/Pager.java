package com.ideracloud.gymcom.dto;

import java.util.List;

public class Pager<D extends BaseDto>{
    private Integer pageNumber = 0;
    private Integer totalPages = 0;
    private Long totalElements = -1L;
    private Integer pageSize = 10;
    private List<D> content;

    public Pager() {
    }

    public Integer getPageNumber() {
        return this.pageNumber;
    }

    public Integer getTotalPages() {
        return this.totalPages;
    }

    public Long getTotalElements() {
        return this.totalElements;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public List<D> getContent() {
        return this.content;
    }

    public void setPageNumber(final Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setTotalPages(final Integer totalPages) {
        this.totalPages = totalPages;
    }

    public void setTotalElements(final Long totalElements) {
        this.totalElements = totalElements;
    }

    public void setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setContent(final List<D> content) {
        this.content = content;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Pager)) {
            return false;
        } else {
            Pager<?> other = (Pager)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label71: {
                    Object this$pageNumber = this.getPageNumber();
                    Object other$pageNumber = other.getPageNumber();
                    if (this$pageNumber == null) {
                        if (other$pageNumber == null) {
                            break label71;
                        }
                    } else if (this$pageNumber.equals(other$pageNumber)) {
                        break label71;
                    }

                    return false;
                }

                Object this$totalPages = this.getTotalPages();
                Object other$totalPages = other.getTotalPages();
                if (this$totalPages == null) {
                    if (other$totalPages != null) {
                        return false;
                    }
                } else if (!this$totalPages.equals(other$totalPages)) {
                    return false;
                }

                label57: {
                    Object this$totalElements = this.getTotalElements();
                    Object other$totalElements = other.getTotalElements();
                    if (this$totalElements == null) {
                        if (other$totalElements == null) {
                            break label57;
                        }
                    } else if (this$totalElements.equals(other$totalElements)) {
                        break label57;
                    }

                    return false;
                }

                Object this$pageSize = this.getPageSize();
                Object other$pageSize = other.getPageSize();
                if (this$pageSize == null) {
                    if (other$pageSize != null) {
                        return false;
                    }
                } else if (!this$pageSize.equals(other$pageSize)) {
                    return false;
                }

                Object this$content = this.getContent();
                Object other$content = other.getContent();
                if (this$content == null) {
                    if (other$content == null) {
                        return true;
                    }
                } else if (this$content.equals(other$content)) {
                    return true;
                }

                return false;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Pager;
    }

    public int hashCode() {
        int result = 1;
        Object $pageNumber = this.getPageNumber();
        result = result * 59 + ($pageNumber == null ? 43 : $pageNumber.hashCode());
        Object $totalPages = this.getTotalPages();
        result = result * 59 + ($totalPages == null ? 43 : $totalPages.hashCode());
        Object $totalElements = this.getTotalElements();
        result = result * 59 + ($totalElements == null ? 43 : $totalElements.hashCode());
        Object $pageSize = this.getPageSize();
        result = result * 59 + ($pageSize == null ? 43 : $pageSize.hashCode());
        Object $content = this.getContent();
        result = result * 59 + ($content == null ? 43 : $content.hashCode());
        return result;
    }

    public String toString() {
        return "Pager(pageNumber=" + this.getPageNumber() + ", totalPages=" + this.getTotalPages() + ", totalElements=" + this.getTotalElements() + ", pageSize=" + this.getPageSize() + ", content=" + this.getContent() + ")";
    }
}
