package com.netflix.spinnaker.orca.igor;

import jakarta.annotation.Nullable;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ScmService {
  public List compareCommits(
      String repoType,
      String projectKey,
      String repositorySlug,
      Map<String, String> requestParams) {
    return igorService.compareCommits(repoType, projectKey, repositorySlug, requestParams);
  }

  public Map<String, Object> getDeliveryConfigManifest(
      String repoType,
      String projectKey,
      String repositorySlug,
      @Nullable String directory,
      @Nullable String manifest,
      @Nullable String ref) {
    return igorService.getDeliveryConfigManifest(
        repoType, projectKey, repositorySlug, directory, manifest, ref);
  }

  private final IgorService igorService;
}
