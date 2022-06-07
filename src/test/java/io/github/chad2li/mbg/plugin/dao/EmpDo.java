package io.github.chad2li.mbg.plugin.dao;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;

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

    public static class Props {
        public static final String id = "id";

        public static final String name = "name";

        public static final String age = "age";

        public static final String email = "email";

        public static final String createTime = "createTime";
    }
}