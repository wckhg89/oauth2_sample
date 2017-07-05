package com.guppy.oauth2sample.repository;

import com.guppy.oauth2sample.domain.Member;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by kanghonggu on 2017. 7. 5..
 */
@RepositoryRestResource
public interface MemberRepository extends PagingAndSortingRepository<Member, Long>{
}
