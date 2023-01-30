package com.study.study_springboots.utils;

public class Paginations {
    private int pageScale = 10; // 한페이지당 게시물 수
    private int currentPage; // 클릭한 현재 페이지 번호
    private int totalPage; // 전체 페이지
    private int totalCount; // 전체 리스트 갯수
    private int pageBegin; // 페이지 내에서 리스트 시작 번호
    private int pageEnd; // 페이지 내에서 리스트 끝 번호

    public Paginations(int totalCount, int currentPage) {
        this.totalCount = totalCount;
        this.currentPage = currentPage;
        this.setTotalPage(totalCount);
        this.setPageRange();
    }

    public void setPageRange() {
        pageBegin = (this.currentPage - 1) * this.pageScale + 1;
        pageEnd = (this.pageBegin + pageScale) - 1;
    }

    public void setTotalPage(int totalCount) {
        this.totalPage = (int) Math.ceil(totalCount / this.pageScale);
    }

    public int getPageScale() {
        return pageScale;
    }

    public void setPageScale(int pageScale) {
        this.pageScale = pageScale;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageBegin() {
        return pageBegin;
    }

    public void setPageBegin(int pageBegin) {
        this.pageBegin = pageBegin;
    }

    public int getPageEnd() {
        return pageEnd;
    }

    public void setPageEnd(int pageEnd) {
        this.pageEnd = pageEnd;
    }

}
