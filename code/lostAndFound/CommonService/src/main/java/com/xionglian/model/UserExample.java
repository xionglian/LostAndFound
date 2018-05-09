package com.xionglian.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andLoginNameIsNull() {
            addCriterion("login_name is null");
            return (Criteria) this;
        }

        public Criteria andLoginNameIsNotNull() {
            addCriterion("login_name is not null");
            return (Criteria) this;
        }

        public Criteria andLoginNameEqualTo(String value) {
            addCriterion("login_name =", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameNotEqualTo(String value) {
            addCriterion("login_name <>", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameGreaterThan(String value) {
            addCriterion("login_name >", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameGreaterThanOrEqualTo(String value) {
            addCriterion("login_name >=", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameLessThan(String value) {
            addCriterion("login_name <", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameLessThanOrEqualTo(String value) {
            addCriterion("login_name <=", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameLike(String value) {
            addCriterion("login_name like", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameNotLike(String value) {
            addCriterion("login_name not like", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameIn(List<String> values) {
            addCriterion("login_name in", values, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameNotIn(List<String> values) {
            addCriterion("login_name not in", values, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameBetween(String value1, String value2) {
            addCriterion("login_name between", value1, value2, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameNotBetween(String value1, String value2) {
            addCriterion("login_name not between", value1, value2, "loginName");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("tel is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("tel is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("tel =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("tel <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("tel >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("tel >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("tel <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("tel <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("tel like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("tel not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("tel in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("tel not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("tel between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("tel not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andMailIsNull() {
            addCriterion("mail is null");
            return (Criteria) this;
        }

        public Criteria andMailIsNotNull() {
            addCriterion("mail is not null");
            return (Criteria) this;
        }

        public Criteria andMailEqualTo(String value) {
            addCriterion("mail =", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotEqualTo(String value) {
            addCriterion("mail <>", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailGreaterThan(String value) {
            addCriterion("mail >", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailGreaterThanOrEqualTo(String value) {
            addCriterion("mail >=", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLessThan(String value) {
            addCriterion("mail <", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLessThanOrEqualTo(String value) {
            addCriterion("mail <=", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLike(String value) {
            addCriterion("mail like", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotLike(String value) {
            addCriterion("mail not like", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailIn(List<String> values) {
            addCriterion("mail in", values, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotIn(List<String> values) {
            addCriterion("mail not in", values, "mail");
            return (Criteria) this;
        }

        public Criteria andMailBetween(String value1, String value2) {
            addCriterion("mail between", value1, value2, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotBetween(String value1, String value2) {
            addCriterion("mail not between", value1, value2, "mail");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Byte value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Byte value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Byte value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Byte value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Byte value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Byte value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Byte> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Byte> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Byte value1, Byte value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Byte value1, Byte value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andUserImgIsNull() {
            addCriterion("user_img is null");
            return (Criteria) this;
        }

        public Criteria andUserImgIsNotNull() {
            addCriterion("user_img is not null");
            return (Criteria) this;
        }

        public Criteria andUserImgEqualTo(String value) {
            addCriterion("user_img =", value, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgNotEqualTo(String value) {
            addCriterion("user_img <>", value, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgGreaterThan(String value) {
            addCriterion("user_img >", value, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgGreaterThanOrEqualTo(String value) {
            addCriterion("user_img >=", value, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgLessThan(String value) {
            addCriterion("user_img <", value, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgLessThanOrEqualTo(String value) {
            addCriterion("user_img <=", value, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgLike(String value) {
            addCriterion("user_img like", value, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgNotLike(String value) {
            addCriterion("user_img not like", value, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgIn(List<String> values) {
            addCriterion("user_img in", values, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgNotIn(List<String> values) {
            addCriterion("user_img not in", values, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgBetween(String value1, String value2) {
            addCriterion("user_img between", value1, value2, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgNotBetween(String value1, String value2) {
            addCriterion("user_img not between", value1, value2, "userImg");
            return (Criteria) this;
        }

        public Criteria andRoleIsNull() {
            addCriterion("role is null");
            return (Criteria) this;
        }

        public Criteria andRoleIsNotNull() {
            addCriterion("role is not null");
            return (Criteria) this;
        }

        public Criteria andRoleEqualTo(Byte value) {
            addCriterion("role =", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotEqualTo(Byte value) {
            addCriterion("role <>", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThan(Byte value) {
            addCriterion("role >", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThanOrEqualTo(Byte value) {
            addCriterion("role >=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThan(Byte value) {
            addCriterion("role <", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThanOrEqualTo(Byte value) {
            addCriterion("role <=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleIn(List<Byte> values) {
            addCriterion("role in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotIn(List<Byte> values) {
            addCriterion("role not in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleBetween(Byte value1, Byte value2) {
            addCriterion("role between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotBetween(Byte value1, Byte value2) {
            addCriterion("role not between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andSchoolLocationIsNull() {
            addCriterion("school_location is null");
            return (Criteria) this;
        }

        public Criteria andSchoolLocationIsNotNull() {
            addCriterion("school_location is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolLocationEqualTo(String value) {
            addCriterion("school_location =", value, "schoolLocation");
            return (Criteria) this;
        }

        public Criteria andSchoolLocationNotEqualTo(String value) {
            addCriterion("school_location <>", value, "schoolLocation");
            return (Criteria) this;
        }

        public Criteria andSchoolLocationGreaterThan(String value) {
            addCriterion("school_location >", value, "schoolLocation");
            return (Criteria) this;
        }

        public Criteria andSchoolLocationGreaterThanOrEqualTo(String value) {
            addCriterion("school_location >=", value, "schoolLocation");
            return (Criteria) this;
        }

        public Criteria andSchoolLocationLessThan(String value) {
            addCriterion("school_location <", value, "schoolLocation");
            return (Criteria) this;
        }

        public Criteria andSchoolLocationLessThanOrEqualTo(String value) {
            addCriterion("school_location <=", value, "schoolLocation");
            return (Criteria) this;
        }

        public Criteria andSchoolLocationLike(String value) {
            addCriterion("school_location like", value, "schoolLocation");
            return (Criteria) this;
        }

        public Criteria andSchoolLocationNotLike(String value) {
            addCriterion("school_location not like", value, "schoolLocation");
            return (Criteria) this;
        }

        public Criteria andSchoolLocationIn(List<String> values) {
            addCriterion("school_location in", values, "schoolLocation");
            return (Criteria) this;
        }

        public Criteria andSchoolLocationNotIn(List<String> values) {
            addCriterion("school_location not in", values, "schoolLocation");
            return (Criteria) this;
        }

        public Criteria andSchoolLocationBetween(String value1, String value2) {
            addCriterion("school_location between", value1, value2, "schoolLocation");
            return (Criteria) this;
        }

        public Criteria andSchoolLocationNotBetween(String value1, String value2) {
            addCriterion("school_location not between", value1, value2, "schoolLocation");
            return (Criteria) this;
        }

        public Criteria andSecondSchoolIsNull() {
            addCriterion("second_school is null");
            return (Criteria) this;
        }

        public Criteria andSecondSchoolIsNotNull() {
            addCriterion("second_school is not null");
            return (Criteria) this;
        }

        public Criteria andSecondSchoolEqualTo(String value) {
            addCriterion("second_school =", value, "secondSchool");
            return (Criteria) this;
        }

        public Criteria andSecondSchoolNotEqualTo(String value) {
            addCriterion("second_school <>", value, "secondSchool");
            return (Criteria) this;
        }

        public Criteria andSecondSchoolGreaterThan(String value) {
            addCriterion("second_school >", value, "secondSchool");
            return (Criteria) this;
        }

        public Criteria andSecondSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("second_school >=", value, "secondSchool");
            return (Criteria) this;
        }

        public Criteria andSecondSchoolLessThan(String value) {
            addCriterion("second_school <", value, "secondSchool");
            return (Criteria) this;
        }

        public Criteria andSecondSchoolLessThanOrEqualTo(String value) {
            addCriterion("second_school <=", value, "secondSchool");
            return (Criteria) this;
        }

        public Criteria andSecondSchoolLike(String value) {
            addCriterion("second_school like", value, "secondSchool");
            return (Criteria) this;
        }

        public Criteria andSecondSchoolNotLike(String value) {
            addCriterion("second_school not like", value, "secondSchool");
            return (Criteria) this;
        }

        public Criteria andSecondSchoolIn(List<String> values) {
            addCriterion("second_school in", values, "secondSchool");
            return (Criteria) this;
        }

        public Criteria andSecondSchoolNotIn(List<String> values) {
            addCriterion("second_school not in", values, "secondSchool");
            return (Criteria) this;
        }

        public Criteria andSecondSchoolBetween(String value1, String value2) {
            addCriterion("second_school between", value1, value2, "secondSchool");
            return (Criteria) this;
        }

        public Criteria andSecondSchoolNotBetween(String value1, String value2) {
            addCriterion("second_school not between", value1, value2, "secondSchool");
            return (Criteria) this;
        }

        public Criteria andUserClassIsNull() {
            addCriterion("user_class is null");
            return (Criteria) this;
        }

        public Criteria andUserClassIsNotNull() {
            addCriterion("user_class is not null");
            return (Criteria) this;
        }

        public Criteria andUserClassEqualTo(String value) {
            addCriterion("user_class =", value, "userClass");
            return (Criteria) this;
        }

        public Criteria andUserClassNotEqualTo(String value) {
            addCriterion("user_class <>", value, "userClass");
            return (Criteria) this;
        }

        public Criteria andUserClassGreaterThan(String value) {
            addCriterion("user_class >", value, "userClass");
            return (Criteria) this;
        }

        public Criteria andUserClassGreaterThanOrEqualTo(String value) {
            addCriterion("user_class >=", value, "userClass");
            return (Criteria) this;
        }

        public Criteria andUserClassLessThan(String value) {
            addCriterion("user_class <", value, "userClass");
            return (Criteria) this;
        }

        public Criteria andUserClassLessThanOrEqualTo(String value) {
            addCriterion("user_class <=", value, "userClass");
            return (Criteria) this;
        }

        public Criteria andUserClassLike(String value) {
            addCriterion("user_class like", value, "userClass");
            return (Criteria) this;
        }

        public Criteria andUserClassNotLike(String value) {
            addCriterion("user_class not like", value, "userClass");
            return (Criteria) this;
        }

        public Criteria andUserClassIn(List<String> values) {
            addCriterion("user_class in", values, "userClass");
            return (Criteria) this;
        }

        public Criteria andUserClassNotIn(List<String> values) {
            addCriterion("user_class not in", values, "userClass");
            return (Criteria) this;
        }

        public Criteria andUserClassBetween(String value1, String value2) {
            addCriterion("user_class between", value1, value2, "userClass");
            return (Criteria) this;
        }

        public Criteria andUserClassNotBetween(String value1, String value2) {
            addCriterion("user_class not between", value1, value2, "userClass");
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

        public Criteria andIsLoginIsNull() {
            addCriterion("is_login is null");
            return (Criteria) this;
        }

        public Criteria andIsLoginIsNotNull() {
            addCriterion("is_login is not null");
            return (Criteria) this;
        }

        public Criteria andIsLoginEqualTo(Boolean value) {
            addCriterion("is_login =", value, "isLogin");
            return (Criteria) this;
        }

        public Criteria andIsLoginNotEqualTo(Boolean value) {
            addCriterion("is_login <>", value, "isLogin");
            return (Criteria) this;
        }

        public Criteria andIsLoginGreaterThan(Boolean value) {
            addCriterion("is_login >", value, "isLogin");
            return (Criteria) this;
        }

        public Criteria andIsLoginGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_login >=", value, "isLogin");
            return (Criteria) this;
        }

        public Criteria andIsLoginLessThan(Boolean value) {
            addCriterion("is_login <", value, "isLogin");
            return (Criteria) this;
        }

        public Criteria andIsLoginLessThanOrEqualTo(Boolean value) {
            addCriterion("is_login <=", value, "isLogin");
            return (Criteria) this;
        }

        public Criteria andIsLoginIn(List<Boolean> values) {
            addCriterion("is_login in", values, "isLogin");
            return (Criteria) this;
        }

        public Criteria andIsLoginNotIn(List<Boolean> values) {
            addCriterion("is_login not in", values, "isLogin");
            return (Criteria) this;
        }

        public Criteria andIsLoginBetween(Boolean value1, Boolean value2) {
            addCriterion("is_login between", value1, value2, "isLogin");
            return (Criteria) this;
        }

        public Criteria andIsLoginNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_login not between", value1, value2, "isLogin");
            return (Criteria) this;
        }

        public Criteria andPutLostNumIsNull() {
            addCriterion("put_lost_num is null");
            return (Criteria) this;
        }

        public Criteria andPutLostNumIsNotNull() {
            addCriterion("put_lost_num is not null");
            return (Criteria) this;
        }

        public Criteria andPutLostNumEqualTo(Integer value) {
            addCriterion("put_lost_num =", value, "putLostNum");
            return (Criteria) this;
        }

        public Criteria andPutLostNumNotEqualTo(Integer value) {
            addCriterion("put_lost_num <>", value, "putLostNum");
            return (Criteria) this;
        }

        public Criteria andPutLostNumGreaterThan(Integer value) {
            addCriterion("put_lost_num >", value, "putLostNum");
            return (Criteria) this;
        }

        public Criteria andPutLostNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("put_lost_num >=", value, "putLostNum");
            return (Criteria) this;
        }

        public Criteria andPutLostNumLessThan(Integer value) {
            addCriterion("put_lost_num <", value, "putLostNum");
            return (Criteria) this;
        }

        public Criteria andPutLostNumLessThanOrEqualTo(Integer value) {
            addCriterion("put_lost_num <=", value, "putLostNum");
            return (Criteria) this;
        }

        public Criteria andPutLostNumIn(List<Integer> values) {
            addCriterion("put_lost_num in", values, "putLostNum");
            return (Criteria) this;
        }

        public Criteria andPutLostNumNotIn(List<Integer> values) {
            addCriterion("put_lost_num not in", values, "putLostNum");
            return (Criteria) this;
        }

        public Criteria andPutLostNumBetween(Integer value1, Integer value2) {
            addCriterion("put_lost_num between", value1, value2, "putLostNum");
            return (Criteria) this;
        }

        public Criteria andPutLostNumNotBetween(Integer value1, Integer value2) {
            addCriterion("put_lost_num not between", value1, value2, "putLostNum");
            return (Criteria) this;
        }

        public Criteria andPutFoundNumIsNull() {
            addCriterion("put_found_num is null");
            return (Criteria) this;
        }

        public Criteria andPutFoundNumIsNotNull() {
            addCriterion("put_found_num is not null");
            return (Criteria) this;
        }

        public Criteria andPutFoundNumEqualTo(Integer value) {
            addCriterion("put_found_num =", value, "putFoundNum");
            return (Criteria) this;
        }

        public Criteria andPutFoundNumNotEqualTo(Integer value) {
            addCriterion("put_found_num <>", value, "putFoundNum");
            return (Criteria) this;
        }

        public Criteria andPutFoundNumGreaterThan(Integer value) {
            addCriterion("put_found_num >", value, "putFoundNum");
            return (Criteria) this;
        }

        public Criteria andPutFoundNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("put_found_num >=", value, "putFoundNum");
            return (Criteria) this;
        }

        public Criteria andPutFoundNumLessThan(Integer value) {
            addCriterion("put_found_num <", value, "putFoundNum");
            return (Criteria) this;
        }

        public Criteria andPutFoundNumLessThanOrEqualTo(Integer value) {
            addCriterion("put_found_num <=", value, "putFoundNum");
            return (Criteria) this;
        }

        public Criteria andPutFoundNumIn(List<Integer> values) {
            addCriterion("put_found_num in", values, "putFoundNum");
            return (Criteria) this;
        }

        public Criteria andPutFoundNumNotIn(List<Integer> values) {
            addCriterion("put_found_num not in", values, "putFoundNum");
            return (Criteria) this;
        }

        public Criteria andPutFoundNumBetween(Integer value1, Integer value2) {
            addCriterion("put_found_num between", value1, value2, "putFoundNum");
            return (Criteria) this;
        }

        public Criteria andPutFoundNumNotBetween(Integer value1, Integer value2) {
            addCriterion("put_found_num not between", value1, value2, "putFoundNum");
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