package pfe.sopra.elearningplatform.service.unityServices;

import pfe.sopra.elearningplatform.dao.UnityRepository;
import pfe.sopra.elearningplatform.dto.UnityDTO;
import pfe.sopra.elearningplatform.entity.Unity;

import java.util.List;

public interface UnityServices {
 public Unity createUnity(Unity unity);
 public Unity updateUnity(Unity unity);
 public List<Unity> getUnitys();
 public Unity getUnity(Long id);
 public void deleteUnity(Long id);
 public List<Unity> searchUnity(String unityName);
 public List<UnityDTO> userUnities (String username);
 public List<UnityDTO> getFormationUnities(Long formationId);
 public List<UnityDTO> getSectionsUnitie(Long unityId);


}
