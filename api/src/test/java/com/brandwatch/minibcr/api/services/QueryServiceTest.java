package com.brandwatch.minibcr.api.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.brandwatch.minibcr.api.exceptions.EmptyQueryException;
import com.brandwatch.minibcr.api.exceptions.QueryNotFoundException;
import com.brandwatch.minibcr.common.domain.Query;
import com.brandwatch.minibcr.common.repository.query.QueryRepository;

@RunWith(MockitoJUnitRunner.class)
public class QueryServiceTest {

    @Mock
    QueryRepository queryRepositoryMock;

    @InjectMocks
    QueryService queryService;

    @Test(expected = QueryNotFoundException.class)
    public void givenQueryDoesNotExist_thenThrowQueryNotFoundException() {
        long randomId = 1738;
        when(queryRepositoryMock.findQueryById(randomId)).thenReturn(null);
        queryService.getQueryById(randomId);
    }

    @Test
    public void givenQueryExists_thenReturnQuery() {
        long validId = 2;
        Query expectedQuery = new Query("This is my query");
        when(queryRepositoryMock.findQueryById(validId)).thenReturn(expectedQuery);
        assertEquals(queryService.getQueryById(validId), expectedQuery);
    }

    @Test
    public void givenNoQueries_thenReturnEmptyList() {
        when(queryRepositoryMock.findAll()).thenReturn(new ArrayList<>());
        assertEquals(queryService.getQueries(), new ArrayList<>());
    }

    @Test
    public void givenQueriesExist_thenReturnQueriesList() {
        List<Query> expectedQueries = new ArrayList<Query>(Arrays.asList(
                new Query("First Query"),
                new Query("Second Query")));
        when(queryRepositoryMock.findAll()).thenReturn(expectedQueries);
        assertEquals(queryService.getQueries(), expectedQueries);
    }

    @Test(expected = EmptyQueryException.class)
    public void givenEmptyString_whenSavingQuery_thenThrowEmptyQueryException() {
        String emptyQuery = "";
        queryService.saveQuery(emptyQuery);
    }
}
