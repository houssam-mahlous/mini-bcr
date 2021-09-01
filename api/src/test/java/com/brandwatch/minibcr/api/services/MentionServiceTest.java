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

import com.brandwatch.minibcr.api.exceptions.MentionNotFoundException;
import com.brandwatch.minibcr.common.domain.Mention;
import com.brandwatch.minibcr.common.repository.mention.MentionRepository;

@RunWith(MockitoJUnitRunner.class)
public class MentionServiceTest {

    @InjectMocks
    private MentionService mentionService;

    @Mock
    private MentionRepository mentionRepositoryMock;

    @Test(expected = MentionNotFoundException.class)
    public void givenMentionDoesNotExist_thenThrowMentionNotFoundException() {
        String randomId = "AS1FDA738";
        when(mentionRepositoryMock.findByMentionId(randomId)).thenReturn(null);
        mentionService.getMentionById(randomId);
    }

    @Test
    public void givenMentionExists_thenReturnMention() {
        String validId = "WAA13AS1O";
        Mention expectedMention = new Mention();
        when(mentionRepositoryMock.findByMentionId(validId)).thenReturn(expectedMention);
        assertEquals(mentionService.getMentionById(validId), expectedMention);
    }

    @Test
    public void givenNoMentions_thenReturnEmptyList() {
        when(mentionRepositoryMock.readAllMentions()).thenReturn(new ArrayList<>());
        assertEquals(mentionService.getMentions(), new ArrayList<>());
    }

    @Test
    public void givenMentionsExist_thenReturnMentionsList() {
        List<Mention> expectedMentions = new ArrayList<Mention>(Arrays.asList(
                new Mention(), new Mention()));
        when(mentionRepositoryMock.readAllMentions()).thenReturn(expectedMentions);
        assertEquals(mentionService.getMentions(), expectedMentions);
    }
}
