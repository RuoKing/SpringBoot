package spring.SpringBoot.mapper;

import org.springframework.stereotype.Repository;
import spring.SpringBoot.entry.FavoriteInfo;

import java.util.List;

@Repository
public interface FavoriteInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FavoriteInfo record);

    int insertSelective(FavoriteInfo record);

    FavoriteInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FavoriteInfo record);

    int updateByPrimaryKey(FavoriteInfo record);

    List<FavoriteInfo> getFavoriteInfoList(String subscriberWallet);
}