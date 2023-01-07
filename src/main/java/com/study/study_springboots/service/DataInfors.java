package com.study.study_springboots.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.study.study_springboots.beans.BoardBean;

public class DataInfors {
    // search 인풋
    public HashMap<String, String> getSearchFormData() {

        HashMap<String, String> searchForm = new HashMap<String, String>();
        searchForm.put("search_key", "Search Title");
        searchForm.put("name", "진보경!");
        searchForm.put("id", "ID0001");
        return searchForm;
    }

    // 테이블
    public ArrayList<String> getTablesListWithString() {
        ArrayList<String> tablesListWithString = new ArrayList<String>();
        tablesListWithString.add("@mdo");
        tablesListWithString.add("@fat");
        tablesListWithString.add("@twitter");
        return tablesListWithString;
    }

    // 다른유형 합치기 모든 유형을 넣어서 골라 쓰기
    public HashMap<String, Object> getBundlesData() {
        DataInfors datainfors = new DataInfors();
        HashMap<String, String> searchForm = datainfors.getSearchFormData();
        ArrayList<String> tablesListWithString = datainfors.getTablesListWithString();

        // 앞에만 제대로 선언하면 가능. 둘 데이터를 합침
        HashMap<String, Object> bundlesData = new HashMap<>();
        // 키는 다른이름 가능
        bundlesData.put("searchForm", searchForm);
        bundlesData.put("tablesListWithString", tablesListWithString);

        // 이런경우가 매우 많당 데이터를 통채로 담아서 옮기기
        bundlesData.put("dataWithMemberBean", datainfors.getDataWithMemberBean());

        bundlesData.put("dataListWithMemberBean", datainfors.getDataListWithMemberBean());

        return bundlesData;
    }

    public BoardBean getDataWithMemberBean() {
        BoardBean boardBean = new BoardBean();
        boardBean.setTitle("Mark");
        boardBean.setContent("otto");
        boardBean.setUserName("@mdo");

        return boardBean;
    }

    public ArrayList<BoardBean> getDataListWithMemberBean() {
        ArrayList<BoardBean> membersList = new ArrayList<>();
        BoardBean boardBean = new BoardBean();
        boardBean.setTitle("Mark");
        boardBean.setContent("otto");
        boardBean.setUserName("@mdo");
        membersList.add(boardBean);

        BoardBean boardBean02 = new BoardBean();
        boardBean02.setTitle("Jacob");
        boardBean02.setContent("Thornton");
        boardBean02.setUserName("@fat");
        membersList.add(boardBean02);

        BoardBean boardBean03 = new BoardBean();
        boardBean03.setTitle("Larry");
        boardBean03.setContent("Bird");
        boardBean03.setUserName("@twitter");
        membersList.add(boardBean03);

        return membersList;
    }

}
