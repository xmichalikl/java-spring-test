package sk.uteg.springdatatest.api.service;

import sk.uteg.springdatatest.api.exception.NotFoundException;
import sk.uteg.springdatatest.api.model.CampaignSummary;

import java.util.UUID;

public interface CampaignService {
    CampaignSummary getCampaignSummary(UUID campaignId) throws NotFoundException;
}
