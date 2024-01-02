package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {
    private final EntityManager em;

    public void save(Item item) {
        if (item.getId() == null) { // 아이디 값이 없으면 최초
            em.persist(item);
        } else { // 값이 있다면 업데이트(정확하게 업데이트는 아님)
            // ItemService 의 업데이트 아이템 코드랑 같은 내용
            // item 내의 모든 값으로 바꿔치기 (업데이트)
            // 멤버 변수의 값 중 null 이 있다면 문제가 생길 수 있음
            // 완전 바꿔치기의 개념이기 때문에 선택할 수 없음
            em.merge(item);
        }
    }

    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

   public List<Item> findAll() {
        return em.createQuery("SELECT i FROM Item i", Item.class)
                .getResultList();
   }
}
