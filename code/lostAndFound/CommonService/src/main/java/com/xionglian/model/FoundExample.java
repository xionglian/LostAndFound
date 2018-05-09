package com.xionglian.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FoundExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FoundExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andReleaseUserIdIsNull() {
            addCriterion("release_user_id is null");
            return (Criteria) this;
        }

        public Criteria andReleaseUserIdIsNotNull() {
            addCriterion("release_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseUserIdEqualTo(Integer value) {
            addCriterion("release_user_id =", value, "releaseUserId");
            return (Criteria) this;
        }

        public Criteria andReleaseUserIdNotEqualTo(Integer value) {
            addCriterion("release_user_id <>", value, "releaseUserId");
            return (Criteria) this;
        }

        public Criteria andReleaseUserIdGreaterThan(Integer value) {
            addCriterion("release_user_id >", value, "releaseUserId");
            return (Criteria) this;
        }

        public Criteria andReleaseUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("release_user_id >=", value, "releaseUserId");
            return (Criteria) this;
        }

        public Criteria andReleaseUserIdLessThan(Integer value) {
            addCriterion("release_user_id <", value, "releaseUserId");
            return (Criteria) this;
        }

        public Criteria andReleaseUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("release_user_id <=", value, "releaseUserId");
            return (Criteria) this;
        }

        public Criteria andReleaseUserIdIn(List<Integer> values) {
            addCriterion("release_user_id in", values, "releaseUserId");
            return (Criteria) this;
        }

        public Criteria andReleaseUserIdNotIn(List<Integer> values) {
            addCriterion("release_user_id not in", values, "releaseUserId");
            return (Criteria) this;
        }

        public Criteria andReleaseUserIdBetween(Integer value1, Integer value2) {
            addCriterion("release_user_id between", value1, value2, "releaseUserId");
            return (Criteria) this;
        }

        public Criteria andReleaseUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("release_user_id not between", value1, value2, "releaseUserId");
            return (Criteria) this;
        }

        public Criteria andConfirmFoundUserIdIsNull() {
            addCriterion("confirm_found_user_id is null");
            return (Criteria) this;
        }

        public Criteria andConfirmFoundUserIdIsNotNull() {
            addCriterion("confirm_found_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmFoundUserIdEqualTo(Integer value) {
            addCriterion("confirm_found_user_id =", value, "confirmFoundUserId");
            return (Criteria) this;
        }

        public Criteria andConfirmFoundUserIdNotEqualTo(Integer value) {
            addCriterion("confirm_found_user_id <>", value, "confirmFoundUserId");
            return (Criteria) this;
        }

        public Criteria andConfirmFoundUserIdGreaterThan(Integer value) {
            addCriterion("confirm_found_user_id >", value, "confirmFoundUserId");
            return (Criteria) this;
        }

        public Criteria andConfirmFoundUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("confirm_found_user_id >=", value, "confirmFoundUserId");
            return (Criteria) this;
        }

        public Criteria andConfirmFoundUserIdLessThan(Integer value) {
            addCriterion("confirm_found_user_id <", value, "confirmFoundUserId");
            return (Criteria) this;
        }

        public Criteria andConfirmFoundUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("confirm_found_user_id <=", value, "confirmFoundUserId");
            return (Criteria) this;
        }

        public Criteria andConfirmFoundUserIdIn(List<Integer> values) {
            addCriterion("confirm_found_user_id in", values, "confirmFoundUserId");
            return (Criteria) this;
        }

        public Criteria andConfirmFoundUserIdNotIn(List<Integer> values) {
            addCriterion("confirm_found_user_id not in", values, "confirmFoundUserId");
            return (Criteria) this;
        }

        public Criteria andConfirmFoundUserIdBetween(Integer value1, Integer value2) {
            addCriterion("confirm_found_user_id between", value1, value2, "confirmFoundUserId");
            return (Criteria) this;
        }

        public Criteria andConfirmFoundUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("confirm_found_user_id not between", value1, value2, "confirmFoundUserId");
            return (Criteria) this;
        }

        public Criteria andLinkNameIsNull() {
            addCriterion("link_name is null");
            return (Criteria) this;
        }

        public Criteria andLinkNameIsNotNull() {
            addCriterion("link_name is not null");
            return (Criteria) this;
        }

        public Criteria andLinkNameEqualTo(String value) {
            addCriterion("link_name =", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameNotEqualTo(String value) {
            addCriterion("link_name <>", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameGreaterThan(String value) {
            addCriterion("link_name >", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameGreaterThanOrEqualTo(String value) {
            addCriterion("link_name >=", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameLessThan(String value) {
            addCriterion("link_name <", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameLessThanOrEqualTo(String value) {
            addCriterion("link_name <=", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameLike(String value) {
            addCriterion("link_name like", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameNotLike(String value) {
            addCriterion("link_name not like", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameIn(List<String> values) {
            addCriterion("link_name in", values, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameNotIn(List<String> values) {
            addCriterion("link_name not in", values, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameBetween(String value1, String value2) {
            addCriterion("link_name between", value1, value2, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameNotBetween(String value1, String value2) {
            addCriterion("link_name not between", value1, value2, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneIsNull() {
            addCriterion("link_phone is null");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneIsNotNull() {
            addCriterion("link_phone is not null");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneEqualTo(String value) {
            addCriterion("link_phone =", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneNotEqualTo(String value) {
            addCriterion("link_phone <>", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneGreaterThan(String value) {
            addCriterion("link_phone >", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("link_phone >=", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneLessThan(String value) {
            addCriterion("link_phone <", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneLessThanOrEqualTo(String value) {
            addCriterion("link_phone <=", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneLike(String value) {
            addCriterion("link_phone like", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneNotLike(String value) {
            addCriterion("link_phone not like", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneIn(List<String> values) {
            addCriterion("link_phone in", values, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneNotIn(List<String> values) {
            addCriterion("link_phone not in", values, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneBetween(String value1, String value2) {
            addCriterion("link_phone between", value1, value2, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneNotBetween(String value1, String value2) {
            addCriterion("link_phone not between", value1, value2, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andGoodTypeIsNull() {
            addCriterion("good_type is null");
            return (Criteria) this;
        }

        public Criteria andGoodTypeIsNotNull() {
            addCriterion("good_type is not null");
            return (Criteria) this;
        }

        public Criteria andGoodTypeEqualTo(String value) {
            addCriterion("good_type =", value, "goodType");
            return (Criteria) this;
        }

        public Criteria andGoodTypeNotEqualTo(String value) {
            addCriterion("good_type <>", value, "goodType");
            return (Criteria) this;
        }

        public Criteria andGoodTypeGreaterThan(String value) {
            addCriterion("good_type >", value, "goodType");
            return (Criteria) this;
        }

        public Criteria andGoodTypeGreaterThanOrEqualTo(String value) {
            addCriterion("good_type >=", value, "goodType");
            return (Criteria) this;
        }

        public Criteria andGoodTypeLessThan(String value) {
            addCriterion("good_type <", value, "goodType");
            return (Criteria) this;
        }

        public Criteria andGoodTypeLessThanOrEqualTo(String value) {
            addCriterion("good_type <=", value, "goodType");
            return (Criteria) this;
        }

        public Criteria andGoodTypeLike(String value) {
            addCriterion("good_type like", value, "goodType");
            return (Criteria) this;
        }

        public Criteria andGoodTypeNotLike(String value) {
            addCriterion("good_type not like", value, "goodType");
            return (Criteria) this;
        }

        public Criteria andGoodTypeIn(List<String> values) {
            addCriterion("good_type in", values, "goodType");
            return (Criteria) this;
        }

        public Criteria andGoodTypeNotIn(List<String> values) {
            addCriterion("good_type not in", values, "goodType");
            return (Criteria) this;
        }

        public Criteria andGoodTypeBetween(String value1, String value2) {
            addCriterion("good_type between", value1, value2, "goodType");
            return (Criteria) this;
        }

        public Criteria andGoodTypeNotBetween(String value1, String value2) {
            addCriterion("good_type not between", value1, value2, "goodType");
            return (Criteria) this;
        }

        public Criteria andGoodNameIsNull() {
            addCriterion("good_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodNameIsNotNull() {
            addCriterion("good_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodNameEqualTo(String value) {
            addCriterion("good_name =", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameNotEqualTo(String value) {
            addCriterion("good_name <>", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameGreaterThan(String value) {
            addCriterion("good_name >", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameGreaterThanOrEqualTo(String value) {
            addCriterion("good_name >=", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameLessThan(String value) {
            addCriterion("good_name <", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameLessThanOrEqualTo(String value) {
            addCriterion("good_name <=", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameLike(String value) {
            addCriterion("good_name like", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameNotLike(String value) {
            addCriterion("good_name not like", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameIn(List<String> values) {
            addCriterion("good_name in", values, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameNotIn(List<String> values) {
            addCriterion("good_name not in", values, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameBetween(String value1, String value2) {
            addCriterion("good_name between", value1, value2, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameNotBetween(String value1, String value2) {
            addCriterion("good_name not between", value1, value2, "goodName");
            return (Criteria) this;
        }

        public Criteria andFoundAddressIsNull() {
            addCriterion("found_address is null");
            return (Criteria) this;
        }

        public Criteria andFoundAddressIsNotNull() {
            addCriterion("found_address is not null");
            return (Criteria) this;
        }

        public Criteria andFoundAddressEqualTo(String value) {
            addCriterion("found_address =", value, "foundAddress");
            return (Criteria) this;
        }

        public Criteria andFoundAddressNotEqualTo(String value) {
            addCriterion("found_address <>", value, "foundAddress");
            return (Criteria) this;
        }

        public Criteria andFoundAddressGreaterThan(String value) {
            addCriterion("found_address >", value, "foundAddress");
            return (Criteria) this;
        }

        public Criteria andFoundAddressGreaterThanOrEqualTo(String value) {
            addCriterion("found_address >=", value, "foundAddress");
            return (Criteria) this;
        }

        public Criteria andFoundAddressLessThan(String value) {
            addCriterion("found_address <", value, "foundAddress");
            return (Criteria) this;
        }

        public Criteria andFoundAddressLessThanOrEqualTo(String value) {
            addCriterion("found_address <=", value, "foundAddress");
            return (Criteria) this;
        }

        public Criteria andFoundAddressLike(String value) {
            addCriterion("found_address like", value, "foundAddress");
            return (Criteria) this;
        }

        public Criteria andFoundAddressNotLike(String value) {
            addCriterion("found_address not like", value, "foundAddress");
            return (Criteria) this;
        }

        public Criteria andFoundAddressIn(List<String> values) {
            addCriterion("found_address in", values, "foundAddress");
            return (Criteria) this;
        }

        public Criteria andFoundAddressNotIn(List<String> values) {
            addCriterion("found_address not in", values, "foundAddress");
            return (Criteria) this;
        }

        public Criteria andFoundAddressBetween(String value1, String value2) {
            addCriterion("found_address between", value1, value2, "foundAddress");
            return (Criteria) this;
        }

        public Criteria andFoundAddressNotBetween(String value1, String value2) {
            addCriterion("found_address not between", value1, value2, "foundAddress");
            return (Criteria) this;
        }

        public Criteria andFoundAddressDetailIsNull() {
            addCriterion("found_address_detail is null");
            return (Criteria) this;
        }

        public Criteria andFoundAddressDetailIsNotNull() {
            addCriterion("found_address_detail is not null");
            return (Criteria) this;
        }

        public Criteria andFoundAddressDetailEqualTo(String value) {
            addCriterion("found_address_detail =", value, "foundAddressDetail");
            return (Criteria) this;
        }

        public Criteria andFoundAddressDetailNotEqualTo(String value) {
            addCriterion("found_address_detail <>", value, "foundAddressDetail");
            return (Criteria) this;
        }

        public Criteria andFoundAddressDetailGreaterThan(String value) {
            addCriterion("found_address_detail >", value, "foundAddressDetail");
            return (Criteria) this;
        }

        public Criteria andFoundAddressDetailGreaterThanOrEqualTo(String value) {
            addCriterion("found_address_detail >=", value, "foundAddressDetail");
            return (Criteria) this;
        }

        public Criteria andFoundAddressDetailLessThan(String value) {
            addCriterion("found_address_detail <", value, "foundAddressDetail");
            return (Criteria) this;
        }

        public Criteria andFoundAddressDetailLessThanOrEqualTo(String value) {
            addCriterion("found_address_detail <=", value, "foundAddressDetail");
            return (Criteria) this;
        }

        public Criteria andFoundAddressDetailLike(String value) {
            addCriterion("found_address_detail like", value, "foundAddressDetail");
            return (Criteria) this;
        }

        public Criteria andFoundAddressDetailNotLike(String value) {
            addCriterion("found_address_detail not like", value, "foundAddressDetail");
            return (Criteria) this;
        }

        public Criteria andFoundAddressDetailIn(List<String> values) {
            addCriterion("found_address_detail in", values, "foundAddressDetail");
            return (Criteria) this;
        }

        public Criteria andFoundAddressDetailNotIn(List<String> values) {
            addCriterion("found_address_detail not in", values, "foundAddressDetail");
            return (Criteria) this;
        }

        public Criteria andFoundAddressDetailBetween(String value1, String value2) {
            addCriterion("found_address_detail between", value1, value2, "foundAddressDetail");
            return (Criteria) this;
        }

        public Criteria andFoundAddressDetailNotBetween(String value1, String value2) {
            addCriterion("found_address_detail not between", value1, value2, "foundAddressDetail");
            return (Criteria) this;
        }

        public Criteria andFoundTimeIsNull() {
            addCriterion("found_time is null");
            return (Criteria) this;
        }

        public Criteria andFoundTimeIsNotNull() {
            addCriterion("found_time is not null");
            return (Criteria) this;
        }

        public Criteria andFoundTimeEqualTo(Date value) {
            addCriterion("found_time =", value, "foundTime");
            return (Criteria) this;
        }

        public Criteria andFoundTimeNotEqualTo(Date value) {
            addCriterion("found_time <>", value, "foundTime");
            return (Criteria) this;
        }

        public Criteria andFoundTimeGreaterThan(Date value) {
            addCriterion("found_time >", value, "foundTime");
            return (Criteria) this;
        }

        public Criteria andFoundTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("found_time >=", value, "foundTime");
            return (Criteria) this;
        }

        public Criteria andFoundTimeLessThan(Date value) {
            addCriterion("found_time <", value, "foundTime");
            return (Criteria) this;
        }

        public Criteria andFoundTimeLessThanOrEqualTo(Date value) {
            addCriterion("found_time <=", value, "foundTime");
            return (Criteria) this;
        }

        public Criteria andFoundTimeIn(List<Date> values) {
            addCriterion("found_time in", values, "foundTime");
            return (Criteria) this;
        }

        public Criteria andFoundTimeNotIn(List<Date> values) {
            addCriterion("found_time not in", values, "foundTime");
            return (Criteria) this;
        }

        public Criteria andFoundTimeBetween(Date value1, Date value2) {
            addCriterion("found_time between", value1, value2, "foundTime");
            return (Criteria) this;
        }

        public Criteria andFoundTimeNotBetween(Date value1, Date value2) {
            addCriterion("found_time not between", value1, value2, "foundTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andDescriptionDetailIsNull() {
            addCriterion("description_detail is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionDetailIsNotNull() {
            addCriterion("description_detail is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionDetailEqualTo(String value) {
            addCriterion("description_detail =", value, "descriptionDetail");
            return (Criteria) this;
        }

        public Criteria andDescriptionDetailNotEqualTo(String value) {
            addCriterion("description_detail <>", value, "descriptionDetail");
            return (Criteria) this;
        }

        public Criteria andDescriptionDetailGreaterThan(String value) {
            addCriterion("description_detail >", value, "descriptionDetail");
            return (Criteria) this;
        }

        public Criteria andDescriptionDetailGreaterThanOrEqualTo(String value) {
            addCriterion("description_detail >=", value, "descriptionDetail");
            return (Criteria) this;
        }

        public Criteria andDescriptionDetailLessThan(String value) {
            addCriterion("description_detail <", value, "descriptionDetail");
            return (Criteria) this;
        }

        public Criteria andDescriptionDetailLessThanOrEqualTo(String value) {
            addCriterion("description_detail <=", value, "descriptionDetail");
            return (Criteria) this;
        }

        public Criteria andDescriptionDetailLike(String value) {
            addCriterion("description_detail like", value, "descriptionDetail");
            return (Criteria) this;
        }

        public Criteria andDescriptionDetailNotLike(String value) {
            addCriterion("description_detail not like", value, "descriptionDetail");
            return (Criteria) this;
        }

        public Criteria andDescriptionDetailIn(List<String> values) {
            addCriterion("description_detail in", values, "descriptionDetail");
            return (Criteria) this;
        }

        public Criteria andDescriptionDetailNotIn(List<String> values) {
            addCriterion("description_detail not in", values, "descriptionDetail");
            return (Criteria) this;
        }

        public Criteria andDescriptionDetailBetween(String value1, String value2) {
            addCriterion("description_detail between", value1, value2, "descriptionDetail");
            return (Criteria) this;
        }

        public Criteria andDescriptionDetailNotBetween(String value1, String value2) {
            addCriterion("description_detail not between", value1, value2, "descriptionDetail");
            return (Criteria) this;
        }

        public Criteria andKeyWord01IsNull() {
            addCriterion("key_word01 is null");
            return (Criteria) this;
        }

        public Criteria andKeyWord01IsNotNull() {
            addCriterion("key_word01 is not null");
            return (Criteria) this;
        }

        public Criteria andKeyWord01EqualTo(String value) {
            addCriterion("key_word01 =", value, "keyWord01");
            return (Criteria) this;
        }

        public Criteria andKeyWord01NotEqualTo(String value) {
            addCriterion("key_word01 <>", value, "keyWord01");
            return (Criteria) this;
        }

        public Criteria andKeyWord01GreaterThan(String value) {
            addCriterion("key_word01 >", value, "keyWord01");
            return (Criteria) this;
        }

        public Criteria andKeyWord01GreaterThanOrEqualTo(String value) {
            addCriterion("key_word01 >=", value, "keyWord01");
            return (Criteria) this;
        }

        public Criteria andKeyWord01LessThan(String value) {
            addCriterion("key_word01 <", value, "keyWord01");
            return (Criteria) this;
        }

        public Criteria andKeyWord01LessThanOrEqualTo(String value) {
            addCriterion("key_word01 <=", value, "keyWord01");
            return (Criteria) this;
        }

        public Criteria andKeyWord01Like(String value) {
            addCriterion("key_word01 like", value, "keyWord01");
            return (Criteria) this;
        }

        public Criteria andKeyWord01NotLike(String value) {
            addCriterion("key_word01 not like", value, "keyWord01");
            return (Criteria) this;
        }

        public Criteria andKeyWord01In(List<String> values) {
            addCriterion("key_word01 in", values, "keyWord01");
            return (Criteria) this;
        }

        public Criteria andKeyWord01NotIn(List<String> values) {
            addCriterion("key_word01 not in", values, "keyWord01");
            return (Criteria) this;
        }

        public Criteria andKeyWord01Between(String value1, String value2) {
            addCriterion("key_word01 between", value1, value2, "keyWord01");
            return (Criteria) this;
        }

        public Criteria andKeyWord01NotBetween(String value1, String value2) {
            addCriterion("key_word01 not between", value1, value2, "keyWord01");
            return (Criteria) this;
        }

        public Criteria andKeyWord02IsNull() {
            addCriterion("key_word02 is null");
            return (Criteria) this;
        }

        public Criteria andKeyWord02IsNotNull() {
            addCriterion("key_word02 is not null");
            return (Criteria) this;
        }

        public Criteria andKeyWord02EqualTo(String value) {
            addCriterion("key_word02 =", value, "keyWord02");
            return (Criteria) this;
        }

        public Criteria andKeyWord02NotEqualTo(String value) {
            addCriterion("key_word02 <>", value, "keyWord02");
            return (Criteria) this;
        }

        public Criteria andKeyWord02GreaterThan(String value) {
            addCriterion("key_word02 >", value, "keyWord02");
            return (Criteria) this;
        }

        public Criteria andKeyWord02GreaterThanOrEqualTo(String value) {
            addCriterion("key_word02 >=", value, "keyWord02");
            return (Criteria) this;
        }

        public Criteria andKeyWord02LessThan(String value) {
            addCriterion("key_word02 <", value, "keyWord02");
            return (Criteria) this;
        }

        public Criteria andKeyWord02LessThanOrEqualTo(String value) {
            addCriterion("key_word02 <=", value, "keyWord02");
            return (Criteria) this;
        }

        public Criteria andKeyWord02Like(String value) {
            addCriterion("key_word02 like", value, "keyWord02");
            return (Criteria) this;
        }

        public Criteria andKeyWord02NotLike(String value) {
            addCriterion("key_word02 not like", value, "keyWord02");
            return (Criteria) this;
        }

        public Criteria andKeyWord02In(List<String> values) {
            addCriterion("key_word02 in", values, "keyWord02");
            return (Criteria) this;
        }

        public Criteria andKeyWord02NotIn(List<String> values) {
            addCriterion("key_word02 not in", values, "keyWord02");
            return (Criteria) this;
        }

        public Criteria andKeyWord02Between(String value1, String value2) {
            addCriterion("key_word02 between", value1, value2, "keyWord02");
            return (Criteria) this;
        }

        public Criteria andKeyWord02NotBetween(String value1, String value2) {
            addCriterion("key_word02 not between", value1, value2, "keyWord02");
            return (Criteria) this;
        }

        public Criteria andKeyWord03IsNull() {
            addCriterion("key_word03 is null");
            return (Criteria) this;
        }

        public Criteria andKeyWord03IsNotNull() {
            addCriterion("key_word03 is not null");
            return (Criteria) this;
        }

        public Criteria andKeyWord03EqualTo(String value) {
            addCriterion("key_word03 =", value, "keyWord03");
            return (Criteria) this;
        }

        public Criteria andKeyWord03NotEqualTo(String value) {
            addCriterion("key_word03 <>", value, "keyWord03");
            return (Criteria) this;
        }

        public Criteria andKeyWord03GreaterThan(String value) {
            addCriterion("key_word03 >", value, "keyWord03");
            return (Criteria) this;
        }

        public Criteria andKeyWord03GreaterThanOrEqualTo(String value) {
            addCriterion("key_word03 >=", value, "keyWord03");
            return (Criteria) this;
        }

        public Criteria andKeyWord03LessThan(String value) {
            addCriterion("key_word03 <", value, "keyWord03");
            return (Criteria) this;
        }

        public Criteria andKeyWord03LessThanOrEqualTo(String value) {
            addCriterion("key_word03 <=", value, "keyWord03");
            return (Criteria) this;
        }

        public Criteria andKeyWord03Like(String value) {
            addCriterion("key_word03 like", value, "keyWord03");
            return (Criteria) this;
        }

        public Criteria andKeyWord03NotLike(String value) {
            addCriterion("key_word03 not like", value, "keyWord03");
            return (Criteria) this;
        }

        public Criteria andKeyWord03In(List<String> values) {
            addCriterion("key_word03 in", values, "keyWord03");
            return (Criteria) this;
        }

        public Criteria andKeyWord03NotIn(List<String> values) {
            addCriterion("key_word03 not in", values, "keyWord03");
            return (Criteria) this;
        }

        public Criteria andKeyWord03Between(String value1, String value2) {
            addCriterion("key_word03 between", value1, value2, "keyWord03");
            return (Criteria) this;
        }

        public Criteria andKeyWord03NotBetween(String value1, String value2) {
            addCriterion("key_word03 not between", value1, value2, "keyWord03");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Byte value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Byte value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Byte value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Byte value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Byte value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Byte> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Byte> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Byte value1, Byte value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Byte value1, Byte value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeIsNull() {
            addCriterion("confirm_time is null");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeIsNotNull() {
            addCriterion("confirm_time is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeEqualTo(Date value) {
            addCriterion("confirm_time =", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeNotEqualTo(Date value) {
            addCriterion("confirm_time <>", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeGreaterThan(Date value) {
            addCriterion("confirm_time >", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("confirm_time >=", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeLessThan(Date value) {
            addCriterion("confirm_time <", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeLessThanOrEqualTo(Date value) {
            addCriterion("confirm_time <=", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeIn(List<Date> values) {
            addCriterion("confirm_time in", values, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeNotIn(List<Date> values) {
            addCriterion("confirm_time not in", values, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeBetween(Date value1, Date value2) {
            addCriterion("confirm_time between", value1, value2, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeNotBetween(Date value1, Date value2) {
            addCriterion("confirm_time not between", value1, value2, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andPictureUrlIsNull() {
            addCriterion("picture_url is null");
            return (Criteria) this;
        }

        public Criteria andPictureUrlIsNotNull() {
            addCriterion("picture_url is not null");
            return (Criteria) this;
        }

        public Criteria andPictureUrlEqualTo(String value) {
            addCriterion("picture_url =", value, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlNotEqualTo(String value) {
            addCriterion("picture_url <>", value, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlGreaterThan(String value) {
            addCriterion("picture_url >", value, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlGreaterThanOrEqualTo(String value) {
            addCriterion("picture_url >=", value, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlLessThan(String value) {
            addCriterion("picture_url <", value, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlLessThanOrEqualTo(String value) {
            addCriterion("picture_url <=", value, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlLike(String value) {
            addCriterion("picture_url like", value, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlNotLike(String value) {
            addCriterion("picture_url not like", value, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlIn(List<String> values) {
            addCriterion("picture_url in", values, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlNotIn(List<String> values) {
            addCriterion("picture_url not in", values, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlBetween(String value1, String value2) {
            addCriterion("picture_url between", value1, value2, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlNotBetween(String value1, String value2) {
            addCriterion("picture_url not between", value1, value2, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andClickNumIsNull() {
            addCriterion("click_num is null");
            return (Criteria) this;
        }

        public Criteria andClickNumIsNotNull() {
            addCriterion("click_num is not null");
            return (Criteria) this;
        }

        public Criteria andClickNumEqualTo(Integer value) {
            addCriterion("click_num =", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumNotEqualTo(Integer value) {
            addCriterion("click_num <>", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumGreaterThan(Integer value) {
            addCriterion("click_num >", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("click_num >=", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumLessThan(Integer value) {
            addCriterion("click_num <", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumLessThanOrEqualTo(Integer value) {
            addCriterion("click_num <=", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumIn(List<Integer> values) {
            addCriterion("click_num in", values, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumNotIn(List<Integer> values) {
            addCriterion("click_num not in", values, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumBetween(Integer value1, Integer value2) {
            addCriterion("click_num between", value1, value2, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumNotBetween(Integer value1, Integer value2) {
            addCriterion("click_num not between", value1, value2, "clickNum");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}