package com.brandwatch.minibcr.api.controllers;

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

import com.brandwatch.minibcr.api.exceptions.MentionNotFoundException;
import com.brandwatch.minibcr.api.services.MentionService;
import com.brandwatch.minibcr.common.domain.Mention;

@RunWith(MockitoJUnitRunner.class)
public class MentionControllerTest {

    @InjectMocks
    private MentionController mentionController;

    @Mock
    private MentionService mentionServiceMock;

    @Test
    public void givenNoMentions_thenReturnEmptyList() {
        when(mentionServiceMock.getMentions()).thenReturn(new ArrayList<>());
        assertEquals(mentionController.getMentions(), new ArrayList<>());
    }

    @Test
    public void givenMentionsExist_thenReturnMentionsList() {
        List<Mention> expectedMentions = new ArrayList<Mention>(Arrays.asList(
                new Mention(), new Mention()));
        when(mentionServiceMock.getMentions()).thenReturn(expectedMentions);

        assertEquals(mentionController.getMentions(), expectedMentions);
    }

    @Test(expected = MentionNotFoundException.class)
    public void givenMentionDoesNotExist_thenThrowMentionNotFoundException() {
        String randomId = "AS1FDA738";
        when(mentionServiceMock.getMentionById(randomId)).thenThrow(MentionNotFoundException.class);
        mentionController.getMentionById(randomId);
    }

    @Test
    public void givenMentionExists_thenReturnMention() {
        String validId = "WAA13AS1O";
        Mention expectedMention = new Mention();
        when(mentionServiceMock.getMentionById(validId)).thenReturn(expectedMention);
        assertEquals(mentionController.getMentionById(validId), expectedMention);
    }
}
