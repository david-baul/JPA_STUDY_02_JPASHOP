package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
public class Category extends BaseEntity{

    @Id @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "PARENT_ID")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    /* CATEGORY_ITENM table 생성 및 연관관계주인 */
    @ManyToMany
    @JoinTable(name = "CATEGORY_ITEM"
        , joinColumns = @JoinColumn(name = "CATEGORY_ITEM") // 내가(Category) 조인하는하는것 규정
        , inverseJoinColumns = @JoinColumn(name = "ITEM_ID") // 반대쪽(Item)에서 조인하는것 규정
    )
    private List<Item> items = new ArrayList<>();
}
