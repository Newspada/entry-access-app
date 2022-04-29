package com.facchinil.manager;

import com.facchinil.dto.AccessInfoDTO;
import com.facchinil.request.AccessInfoRequest;

public interface AccessInfoManager {
	
	AccessInfoDTO postAccessInfo(AccessInfoRequest request);
}
