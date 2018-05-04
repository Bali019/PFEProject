package pfe.sopra.elearningplatform.service.unityServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pfe.sopra.elearningplatform.dao.EUserRepository;
import pfe.sopra.elearningplatform.dao.UnityRepository;
import pfe.sopra.elearningplatform.dto.UnityDTO;
import pfe.sopra.elearningplatform.entity.EUser;
import pfe.sopra.elearningplatform.entity.Unity;
import pfe.sopra.elearningplatform.service.AccountService;

import java.util.Date;
import java.util.List;
@Service
@Transactional
public class UnityServiceImpl implements UnityServices {
    @Autowired
    private UnityRepository unityRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private EUserRepository eUserRepository;

    @Override
    public Unity createUnity(Unity unity) {
        EUser u = this.accountService.getCurrentUser();
        unity.setUser(u);
        unity.setCreationDate(new Date());
        return unityRepository.save(unity);
    }

    @Override
    public Unity updateUnity(Unity unity) {
        Unity u = unityRepository.findOne(unity.getUnityId());
        unity.setUser(u.getUser());
        unity.setCreationDate(u.getCreationDate());
        return unityRepository.save(unity);
    }

    @Override
    public List<Unity> getUnitys() {
        return unityRepository.findAll();
    }

    @Override
    public Unity getUnity(Long id) {
        return unityRepository.findOne(id);
    }

    @Override
    public void deleteUnity(Long id) {
   unityRepository.delete(id);
    }

    @Override
    public List<Unity> searchUnity(String unityName) {
        return unityRepository.findAllByUnityNameIsContaining(unityName);
    }

    @Override
    public List<UnityDTO> userUnities(String username) {
        return unityRepository.getUserUnities(username);
    }

    @Override
    public List<UnityDTO> getFormationUnities(Long formationId) {
        return unityRepository.getFormationUnities(formationId);
    }
}
