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
