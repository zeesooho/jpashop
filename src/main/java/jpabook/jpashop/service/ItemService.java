package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;


    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    @Transactional
    public void updateItem(Long itemId, /*Book param, */ /*String name, int price, int stockQuantity, */ UpdateItemDto updateItemDto) { // ItemRepository 의 merge 와 같지만 좀 다름
        Item findItem = itemRepository.findOne(itemId);
        findItem.setName(updateItemDto.getName());
        findItem.setPrice(updateItemDto.getPrice());
        findItem.setStockQuantity(updateItemDto.getStockQuantity());
//        itemRepository.save(findItem); // 이런 과정 필요없음
        // JPA 변경 감지 기능을 이용해서 자동으로 업데이트
        // 해당 기능은 null 체크가 가능하기 때문에 merge 대신 직접 set 을 해서 바꾸도록 함
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
}
