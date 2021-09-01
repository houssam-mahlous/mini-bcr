package com.brandwatch.minibcr.api.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;
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
import com.brandwatch.minibcr.api.services.QueryService;
import com.brandwatch.minibcr.common.domain.Query;

@RunWith(MockitoJUnitRunner.class)
public class QueryControllerTest {

    @InjectMocks
    private QueryController queryController;

    @Mock
    private QueryService queryServiceMock;

    @Test
    public void givenNoQueries_thenReturnEmptyList() {
        when(queryServiceMock.getQueries()).thenReturn(new ArrayList<>());
        assertEquals(queryController.getQueries(), new ArrayList<>());
    }

    @Test
    public void givenQueriesExist_thenReturnQueriesList() {
        List<Query> expectedQueries = new ArrayList<Query>(Arrays.asList(
                new Query("First Query"),
                new Query("Second Query")));
        when(queryServiceMock.getQueries()).thenReturn(expectedQueries);
        assertEquals(queryController.getQueries(), expectedQueries);
    }

    @Test(expected = QueryNotFoundException.class)
    public void givenQueryDoesNotExist_thenThrowQueryNotFoundException() {
        long randomId = 1738;
        when(queryServiceMock.getQueryById(randomId)).thenThrow(QueryNotFoundException.class);
        queryController.getQueryById(randomId);
    }

    @Test
    public void givenQueryExists_thenReturnQuery() {
        long validId = 2;
        Query expectedQuery = new Query("This is my query");
        when(queryServiceMock.getQueryById(validId)).thenReturn(expectedQuery);
        assertEquals(queryController.getQueryById(validId), expectedQuery);
    }

    @Test(expected = EmptyQueryException.class)
    public void givenEmptyString_whenSavingQuery_thenThrowEmptyQueryException() {
        String emptyQuery = "";
        doThrow(EmptyQueryException.class).when(queryServiceMock).saveQuery(emptyQuery);
        queryController.saveQuery(emptyQuery);
    }
}
