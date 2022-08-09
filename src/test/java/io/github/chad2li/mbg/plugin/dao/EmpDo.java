package io.github.chad2li.mbg.plugin.dao;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author mbg plus extend
 * @since 1 at 2022-08-09 16:44
 */
@Table(name = "emp")
public class EmpDo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * user name
     */
    private String name;

    /**
     * user age
     */
    private Integer age;

    /**
     * user email
     */
    private String email;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取user name
     *
     * @return name - user name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置user name
     *
     * @param name user name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取user age
     *
     * @return age - user age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置user age
     *
     * @param age user age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取user email
     *
     * @return email - user email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置user email
     *
     * @param email user email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return create_time
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * @author mbg plus extend
     * @since 1 at 2022-08-09 16:44
     */
    public static class Props {
        public static final String ID = "id";

        /**
         * user name
         */
        public static final String NAME = "name";

        /**
         * user age
         */
        public static final String AGE = "age";

        /**
         * user email
         */
        public static final String EMAIL = "email";

        public static final String CREATE_TIME = "createTime";
    }
}